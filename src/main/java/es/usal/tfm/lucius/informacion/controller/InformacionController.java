package es.usal.tfm.lucius.informacion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.usal.tfm.lucius.grafica.dto.ClienteDto;
import es.usal.tfm.lucius.grafica.dto.ContratoDto;
import es.usal.tfm.lucius.grafica.dto.GraficaDto;
import es.usal.tfm.lucius.grafica.service.IClienteService;
import es.usal.tfm.lucius.grafica.service.IContratoService;
import es.usal.tfm.lucius.informacion.service.IInformacionService;
import es.usal.tfm.lucius.informacion.utils.InformacionUtils;

@RestController
public class InformacionController {
	
	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IContratoService contratoService;
	
	@Autowired
	IInformacionService infoService;
	
	@RequestMapping(value="/clientes", method=RequestMethod.GET)
	public ModelAndView viewClientes(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("clientes");
		List<ClienteDto> clientes = clienteService.getAllClientes();
		model.addAttribute("clientes", clientes);
		return mav;
	}
	
	@RequestMapping(value="/contratos", method=RequestMethod.GET)
	public ModelAndView viewContratos(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contratos");
		List<ContratoDto> contratos = contratoService.getAllContratos();
		model.addAttribute("contratos", contratos);
		return mav;
	}
	
	/**
	 * Devuelve un JSON con la informacion por año-mes de los gastos desglosados
	 * @return JSON con la informacion asociada
	 */
	@GetMapping(value="/getStatsTotalesDetalle", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String getStatsTotalesDetalle() {
		Map<String,Map<String,Double>> gastos = infoService.getStatsTotalesDetalle();
		List<String> tags = new ArrayList<String>();
		List<List<Double>> values = new ArrayList<List<Double>>();
		List<Double> luz = new ArrayList<Double>();
		List<Double> subctr = new ArrayList<Double>();
		List<Double> nominas = new ArrayList<Double>();
		List<Double> agua = new ArrayList<Double>();
		gastos.forEach((k,v) -> {
			tags.add(k);
			luz.add(gastos.get(k).get("luz"));
			subctr.add(gastos.get(k).get("subcontratados"));
			nominas.add(gastos.get(k).get("nominas"));
			agua.add(gastos.get(k).get("agua"));
			});
		values.add(luz);
		values.add(subctr);
		values.add(nominas);
		values.add(agua);
		GraficaDto<String, List<Double>> graf = new GraficaDto<String, List<Double>>(tags,values);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(graf);
	}
	
	/**
	 * Devuelve un JSON con la informacion de los clientes y sus contratos asociados
	 * @return JSON con la informacion asociada
	 */
	@GetMapping(value="/getStatsClienteDetalle/{id}", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String getStatsClienteDetalle(@PathVariable("id") String id) {
		ClienteDto cliente = clienteService.getClienteById(id);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(cliente);
	}
	
	/**
	 * Devuelve un JSON con la informacion de los clientes y sus contratos asociados
	 * @return JSON con la informacion asociada
	 */
	@GetMapping(value="/getStatsClienteCpP/{id}", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String getStatsClienteCpP(@PathVariable("id") String id) {
		Map<String, Double> datos = infoService.getStatsClientesCpP(id);
		List<String> tags = new ArrayList<String>();
		List<Double> values = new ArrayList<Double>();
		datos.forEach((k,v) -> {tags.add(k);values.add(v);});
		GraficaDto<String, Double> graf = new GraficaDto<String, Double>(tags,values);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(graf);
	}
	
	/**
	 * Devuelve un JSON con la informacion de los clientes y sus contratos asociados
	 * @return JSON con la informacion asociada
	 */
	@GetMapping(value="/getStatsClienteBalance/{id}", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String getStatsClienteBalance(@PathVariable("id") String id) {
		Map<String, Double> datos = infoService.getStatsClienteBalance(id);
		List<String> tags = new ArrayList<String>();
		List<Double> values = new ArrayList<Double>();
		datos.forEach((k,v) -> {
			tags.add(k);
			values.add(InformacionUtils.fijarNumero(v, 3));
		});
		GraficaDto<String, Double> json = new GraficaDto<String, Double>(tags, values);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(json);
	}
	
	/**
	 * Devuelve un JSON con la informacion de los clientes y sus contratos asociados
	 * @return JSON con la informacion asociada
	 */
	@GetMapping(value="/getStatsClienteGF/{id}", produces=MediaType.APPLICATION_JSON)
	@ResponseBody
	public String getStatsClienteGF(@PathVariable("id") String id) {
		Map<String, Double> datos = infoService.getStatsClienteGF(id);
		List<String> tags = new ArrayList<String>();
		List<Double> values = new ArrayList<Double>();
		datos.forEach((k,v) -> {
			tags.add(k);
			values.add(v);
		});
		GraficaDto<String, Double> json = new GraficaDto<String, Double>(tags, values);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(json);
	}

}
