package kodlama.io.devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.CreateLanguageRequests;
import kodlama.io.devs.business.requests.DeleteLanguageRequests;
import kodlama.io.devs.business.requests.UpdateLanguageRequests;
import kodlama.io.devs.business.responses.GetAllLanguageResponses;
import kodlama.io.devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;
	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	List<GetAllLanguageResponses> getAll(){
		return languageService.getAll();
	}

	@PostMapping("/add")
	void add(CreateLanguageRequests createLanguageRequests) {
		languageService.add(createLanguageRequests);
	}
	
	@GetMapping("/getbyID")
	Language getById(int id) {
		return languageService.getById(id);
	}
	
	@DeleteMapping("/getByID")
	void delete(DeleteLanguageRequests deleteLanguageRequests) {
		languageService.delete(deleteLanguageRequests);
		
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequests updateLanguageRequests) {
		languageService.update(updateLanguageRequests);
	}
	
	
}
