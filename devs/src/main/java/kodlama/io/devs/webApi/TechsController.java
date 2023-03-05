package kodlama.io.devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.TechService;
import kodlama.io.devs.business.requests.CreateTechRequests;
import kodlama.io.devs.business.requests.DeleteTechRequests;
import kodlama.io.devs.business.requests.UpdateTechRequests;
import kodlama.io.devs.business.responses.GetAllTechResponses;

@RestController
@RequestMapping("/api/techs")
public class TechsController {
	private TechService techService;

	@Autowired
	public TechsController(TechService techService) {
		super();
		this.techService = techService;
	}
	
	@GetMapping("/getall")
	List<GetAllTechResponses> getAll(){
		return techService.getAll();
	}
	
	@PostMapping("/add")
	void add(CreateTechRequests createTechRequests) {
		techService.add(createTechRequests);
	}
	
	@DeleteMapping("/delete")
	void delete(DeleteTechRequests deleteTechRequests) {
		techService.delete(deleteTechRequests);
	}
	
	@PutMapping("/update")
	void update(UpdateTechRequests updateTechRequests) {
		techService.update(updateTechRequests);
	}
	
	
	
}
