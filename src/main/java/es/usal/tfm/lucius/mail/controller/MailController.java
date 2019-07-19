package es.usal.tfm.lucius.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.usal.tfm.lucius.mail.service.MailService;

@RestController
public class MailController {
	
	@Autowired
	MailService mailService;

	public MailController() {
		super();
	}
	
	@RequestMapping(value="/sendMailTest", method=RequestMethod.GET)
	public String sendMailTest() {
		mailService.sendEmail();
		return "ok";
	}

}
