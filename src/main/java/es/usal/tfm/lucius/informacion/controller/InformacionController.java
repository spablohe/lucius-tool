package es.usal.tfm.lucius.informacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/stats/total", method=RequestMethod.GET)
	public ModelAndView viewStatsTotales(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("stats_totales");
		List<ContratoDto> contratos = contratoService.getAllContratos();
		model.addAttribute("contratos", contratos);
		return mav;
	}
	
	@RequestMapping(value="/stats/costepieza", method=RequestMethod.GET)
	public ModelAndView viewStatsCostePorPieza(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contratos");
		List<ContratoDto> contratos = contratoService.getAllContratos();
		model.addAttribute("contratos", contratos);
		return mav;
	}
	
	@RequestMapping(value="/stats/clientes", method=RequestMethod.GET)
	public ModelAndView viewStatsClientes(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contratos");
		List<ContratoDto> contratos = contratoService.getAllContratos();
		model.addAttribute("contratos", contratos);
		return mav;
	}

}
