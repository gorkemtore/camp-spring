package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.CreateLanguageRequests;
import kodlama.io.devs.business.requests.DeleteLanguageRequests;
import kodlama.io.devs.business.requests.UpdateLanguageRequests;
import kodlama.io.devs.business.responses.GetAllLanguageResponses;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechRepository;
import kodlama.io.devs.entities.concretes.Language;
import kodlama.io.devs.entities.concretes.Tech;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	private TechRepository techRepository;
	
	public LanguageManager(LanguageRepository languageRepository, TechRepository techRepository) {
		super();
		this.languageRepository = languageRepository;
		this.techRepository = techRepository;
	}

	@Override
	public List<GetAllLanguageResponses> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponses> languageResponses = new ArrayList<>();
		
		Map<Integer, String> techs;
		
		for (Language lang : languages) {
			techs = new HashMap<>();
			GetAllLanguageResponses responseItem = new GetAllLanguageResponses();
			responseItem.setId(lang.getId());
			responseItem.setName(lang.getName());
			
			for(Tech tech : techRepository.findAll()) {
				if(tech.getLanguage() == lang) {
					techs.put(tech.getId(), tech.getName());
				}
			}
			
			responseItem.setTechs(techs);
			
			languageResponses.add(responseItem);
		}

		return languageResponses;
	}

	@Override
	public void add(CreateLanguageRequests createLanguageRequests) {

		List<Language> languages = languageRepository.findAll();
		// isim boşsa false döndürür.
		boolean shouldAdd = !(createLanguageRequests.getName().isEmpty());
		for (Language language : languages) {
			if (createLanguageRequests.getName().equals(language.getName())) {
				shouldAdd = false;
				break;
			}
		}
		if (shouldAdd) {
			Language lang = new Language();
			lang.setName(createLanguageRequests.getName());
			languageRepository.save(lang);
		}
	}

	@Override
	public Language getById(int id) {
		return languageRepository.findById(id).orElseThrow();

	}

	@Override
	public void delete(DeleteLanguageRequests deleteLanguageRequests) {
		languageRepository.deleteById(deleteLanguageRequests.getId());
	}

	@Override
	public void update(UpdateLanguageRequests updateLanguageRequests) {
		List<Language> languages = languageRepository.findAll();
		// isim boşsa false döndürür.
		boolean shouldUpdate = !(updateLanguageRequests.getName().isEmpty());
		for (Language language : languages) {
			if (updateLanguageRequests.getName().equals(language.getName())) {
				shouldUpdate = false;
			}
		}
		if (shouldUpdate) {
			Language language = new Language();
			language.setId(updateLanguageRequests.getId());
			language.setName(updateLanguageRequests.getName());
			languageRepository.save(language);
		}

	}

}
