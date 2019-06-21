package es.usal.tfm.lucius.HomeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.usal.tfm.lucius.comun.dto.ConfigDto;
import es.usal.tfm.lucius.comun.service.IConfigUtils;

@RestController
public class HomeController {
	
	@Autowired
	IConfigUtils configUtils;
	
	@GetMapping("/cargaInicial")
    public String cargaInicial() {
		List<ConfigDto> config = (List<ConfigDto>) configUtils.findAll();
		return config.get(0).getValue();
    }

}
