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
import es.usal.tfm.lucius.grafica.dto.ClienteDto;
import es.usal.tfm.lucius.grafica.dto.ContratoDto;
import es.usal.tfm.lucius.grafica.service.IClienteService;
import es.usal.tfm.lucius.grafica.service.IContratoService;

@RestController
public class HomeController {
	
	@Autowired
	IConfigUtils configUtils;
	
	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IContratoService contratoService;
	
	/**
	 * API REST SECCION COMUNES
	 */
	
	/**
	 * Metodo para recuperar toda la informacion de la tabla config del sistema
	 * @return json con toda la tabla config del sistema
	 */
	@GetMapping(value="/recData", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
    public String recData() {
		List<ConfigDto> config = (List<ConfigDto>) configUtils.findAll();
		EnvioJsonDto<ConfigDto> ejd = new EnvioJsonDto<ConfigDto>("config", config);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(ejd);
    }
	
	/**
	 * Metodo para recuperar un valor de la tabla config del sistema
	 * @param id
	 * @return json con el value asociado al parametro de entrada
	 */
	@GetMapping("/recData/{id}")
    public String recDataId(@PathVariable("id") String id) {
		return configUtils.findById(id);
    }
	
	/**
	 * API REST SECCION CLIENTES
	 */
	
	/**
	 * Metodo para recuperar todos los clientes del sistema
	 * @return json con todos los clientes
	 */
	@GetMapping(value="/getAllClientes", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String recAllClientes() {
		List<ClienteDto> clientes = clienteService.getAllClientes();
		EnvioJsonDto<ClienteDto> ejd = new EnvioJsonDto<ClienteDto>("clientes", clientes);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(ejd);
	}
	
	/**
	 * Metodo para recuperar la informacion de un cliente concreto del sistema
	 * @param id
	 * @return json con los datos del cliente id
	 */
	@GetMapping(value="getCliente/{id}", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String recCliente(@PathVariable("id") String id) {
		ClienteDto cliente = clienteService.getClienteById(id);
		EnvioJsonDto<ClienteDto> ejd = new EnvioJsonDto<ClienteDto>("cliente", cliente);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(ejd);
	}
	
	/**
	 * API REST SECCION CONTRATOS
	 */
	
	/**
	 * Metodo para recuperar toda la informacion de los contratos del sistema
	 * @return json con toda la informacion de los contratos del sistema
	 */
	@GetMapping(value="/getAllContratos", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String recAllContratos() {
		List<ContratoDto> contratos = contratoService.getAllContratos();
		EnvioJsonDto<ClienteDto> ejd = new EnvioJsonDto<ClienteDto>("contratos", contratos);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(ejd);
	}
	
	/**
	 * Metodo para recuperar la informacion de un contrato concreto
	 * @param id
	 * @return json con los datos del contrato concreto
	 */
	@GetMapping(value="getContrato/{id}", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String recContrato(@PathVariable("id") String id) {
		ContratoDto contrato = contratoService.getContratoById(id);
		EnvioJsonDto<ContratoDto> ejd = new EnvioJsonDto<ContratoDto>("contrato", contrato);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(ejd);
	}

}
