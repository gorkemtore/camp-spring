package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service //bu sınıf bir business nesnesidir
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	
	public BrandManager(BrandRepository theBrandRepository) {
		brandRepository = theBrandRepository;
	}
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
		// iş kuralları
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandResponse = new ArrayList<>();
		for (Brand brand : brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			brandResponse.add(responseItem);
		}
		return brandResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = new Brand(); //entity, response, request gibi nesneler newlenebilir.
		brand.setName(createBrandRequest.getName());
		this.brandRepository.save(brand);
		
	}
	

}
