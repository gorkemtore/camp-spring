package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

	boolean existsByName(String name);//spring jpa burada bizim için metodu ayarlayacak.
	//spring jpa keywords
	
}
