package es.usal.tfm.lucius.estimador.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import es.usal.tfm.lucius.estimador.dto.EstimadorDto;

@RestController
public class EstimadorController {

	@RequestMapping(value = "/sendFormularioEstimacion", method = RequestMethod.POST)
	public ModelAndView sendFormularioEstimacion(@ModelAttribute("estimadorDto") EstimadorDto estimadorDto,
			Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("estimador_web");
		model.addAttribute("estimacion", 1.23);
		return mav;
	}

}
