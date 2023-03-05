package kodlama.io.devs.business.responses;

import kodlama.io.devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTechResponses {
	private int id;
	private String name;
	private Language language;
}
