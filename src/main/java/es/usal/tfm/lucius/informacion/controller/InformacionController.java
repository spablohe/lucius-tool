package es.usal.tfm.lucius.informacion.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.usal.tfm.lucius.comun.dto.EnvioJsonDto;
import es.usal.tfm.lucius.grafica.dto.ClienteDto;
import es.usal.tfm.lucius.grafica.dto.ContratoDto;
import es.usal.tfm.lucius.grafica.service.IClienteService;
import es.usal.tfm.lucius.grafica.service.IContratoService;

@RestController
public class InformacionController {
	
	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IContratoService contratoService;
	
	@GetMapping(value="/getInfoCliente/{id}", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String recInfoClientes(@PathVariable("id") String id) {
		ClienteDto cliente = clienteService.getClienteById(id);
		List<ContratoDto> contratos = contratoService.getContratosByClienteId(id);
		EnvioJsonDto<ContratoDto> ejd = new EnvioJsonDto<ContratoDto>("info-cliente", cliente, contratos);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(ejd);
	}

}
