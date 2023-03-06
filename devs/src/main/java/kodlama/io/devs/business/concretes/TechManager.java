package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechService;
import kodlama.io.devs.business.requests.CreateTechRequests;
import kodlama.io.devs.business.requests.DeleteTechRequests;
import kodlama.io.devs.business.requests.UpdateTechRequests;
import kodlama.io.devs.business.responses.GetAllTechResponses;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechRepository;
import kodlama.io.devs.entities.concretes.Language;
import kodlama.io.devs.entities.concretes.Tech;

@Service
public class TechManager implements TechService {
	private TechRepository techRepository;
	private LanguageRepository languageRepository;

	public TechManager(TechRepository techRepository, LanguageRepository languageRepository) {
		super();
		this.techRepository = techRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllTechResponses> getAll() {
		List<Tech> technologies = techRepository.findAll();
		List<GetAllTechResponses> techResponses = new ArrayList<>();
		for (Tech tech : technologies) {
			GetAllTechResponses responseItem = new GetAllTechResponses();
			responseItem.setId(tech.getId());
			responseItem.setName(tech.getName());
			responseItem.setLanguage(tech.getLanguage());
			techResponses.add(responseItem);
		}
		return techResponses;
	}

	@Override
	public void add(@NotNull CreateTechRequests createTechRequests) {
		Tech tech = new Tech();
		tech.setName(createTechRequests.getName());

		for (Language language : languageRepository.findAll()) {
			if (createTechRequests.getLanguage_id() == language.getId()) {
				tech.setLanguage(language);
			}
		}

		techRepository.save(tech);

	}

	@Override
	public void delete(DeleteTechRequests deleteTechRequests) {

		techRepository.deleteById(deleteTechRequests.getId());

	}

	@Override
	public void update(UpdateTechRequests updateTechRequests) {

		Tech tech = techRepository.findById(updateTechRequests.getId()).orElseThrow();

		tech.setName(updateTechRequests.getName());
		techRepository.save(tech);

	}

}
