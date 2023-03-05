package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service //bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	@Override
	public List<GetAllBrandResponse> getAll() {
		// iş kuralları
		List<Brand> brands = brandRepository.findAll();
//		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
//		
//		for (Brand brand : brands) {
//			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//			responseItem.setId(brand.getId());
//			responseItem.setName(brand.getName());
//			brandsResponse.add(responseItem);
//		}
//		
		List<GetAllBrandResponse> brandsResponse = brands.stream().
				map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class))
				.collect(Collectors.toList());
		return brandsResponse;
		
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		Brand brand = this.modelMapperService.forRequest()
				.map(createBrandRequest, Brand.class);
		
		//forRequest brandı newler, alanları karşılaştırır ve aynı olanları mapler.

		this.brandRepository.save(brand);
		
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response =
				this.modelMapperService.forResponse()
				.map(brand, GetByIdBrandResponse.class);

		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest()
				.map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
	}
	

}
