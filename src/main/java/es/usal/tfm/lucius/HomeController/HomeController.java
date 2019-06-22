package es.usal.tfm.lucius.HomeController;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.usal.tfm.lucius.comun.dto.ConfigDto;
import es.usal.tfm.lucius.comun.dto.EnvioJsonDto;
import es.usal.tfm.lucius.comun.service.IConfigUtils;

@RestController
public class HomeController {
	
	@Autowired
	IConfigUtils configUtils;
	
	@GetMapping(value="/recData", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
    public String recData() {
		List<ConfigDto> config = (List<ConfigDto>) configUtils.findAll();
		EnvioJsonDto<ConfigDto> ejd = new EnvioJsonDto<ConfigDto>("data", config);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(ejd);
    }
	
	@GetMapping("/recData/{id}")
    public String recDataId(@PathVariable("id") String id) {
		String value = configUtils.findById(id);
		return value;
    }

}
