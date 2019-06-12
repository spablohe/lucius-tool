package es.usal.tfm.lucius.HomeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/cargaInicial")
    public String cargaInicial() {
		return "Hola, aqui estoy";
    }

}
