package kodlama.io.devs.business.responses;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguageResponses {

	private int id;
	private String name;
	private Map<Integer, String> techs;

}
