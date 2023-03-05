package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateLanguageRequests;
import kodlama.io.devs.business.requests.DeleteLanguageRequests;
import kodlama.io.devs.business.requests.UpdateLanguageRequests;
import kodlama.io.devs.business.responses.GetAllLanguageResponses;
import kodlama.io.devs.entities.concretes.Language;

public interface LanguageService {
	List<GetAllLanguageResponses> getAll();
	void add(CreateLanguageRequests createLanguageRequests);
	Language getById(int id );
	void delete(DeleteLanguageRequests deleteLanguageRequests);
	void update(UpdateLanguageRequests updateLanguageRequests);
}
