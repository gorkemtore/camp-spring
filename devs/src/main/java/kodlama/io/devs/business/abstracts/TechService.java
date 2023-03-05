package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateTechRequests;
import kodlama.io.devs.business.requests.DeleteTechRequests;
import kodlama.io.devs.business.requests.UpdateTechRequests;
import kodlama.io.devs.business.responses.GetAllTechResponses;

public interface TechService {
	List<GetAllTechResponses> getAll(); 
	void add(CreateTechRequests createTechRequests);
	void delete(DeleteTechRequests deleteTechRequests);
	void update(UpdateTechRequests updateTechRequests);
}
