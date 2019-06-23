package es.usal.tfm.lucius.informacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import es.usal.tfm.lucius.grafica.dto.ClienteDto;
import es.usal.tfm.lucius.grafica.service.IClienteService;
import es.usal.tfm.lucius.grafica.service.IContratoService;

@RestController
public class InformacionController {
	
	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IContratoService contratoService;
	
	@RequestMapping(value="/clientes", method=RequestMethod.GET)
	public ModelAndView recInfoClientes(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("clientes");
		List<ClienteDto> clientes = clienteService.getAllClientes();
		model.addAttribute("clientes", clientes);
		return mav;
	}

}
