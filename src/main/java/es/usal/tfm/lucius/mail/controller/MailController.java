package es.usal.tfm.lucius.mail.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.usal.tfm.lucius.mail.dto.EmailDto;
import es.usal.tfm.lucius.mail.service.MailService;

@RestController
public class MailController {
	
	@Autowired
	MailService mailService;

	public MailController() {
		super();
	}
	
	@PostMapping(value = "/sendemail")
	public EmailDto emailHtmlTemplate(@RequestBody EmailDto email) throws IOException, MessagingException {

		mailService.sendEmail(email);

		return email;
	}

	@PostMapping(value = "/sendtextemail")
	public EmailDto emailTextTemplate(@RequestBody EmailDto email) throws IOException, MessagingException {

		mailService.sendTextTemplateEmail(email);

		return email;
	}

	@GetMapping(value = "/sendhtmlemail")
	public EmailDto emailInHtmlTemplate() throws IOException, MessagingException {
		EmailDto mail = new EmailDto();
		mail.setFrom("spablohe@gmail.com");
		mail.setHtml(true);
		mail.setMessage("Este es un mail de prueba");
		mail.setSubject("Mensaje de prueba");
		mail.setTemplateName("email-inlineimage");
		mail.setTemplate(true);
		mail.setAttachmentName("");
		mail.setEmailedMessage("emailedmessaged");
		mail.setHasAttachment(false);
		mail.setParameterMap(new HashMap<String,Object>());
		mail.setStaticResourceMap(new HashMap<String,Object>());
		String [] dest = {"sergiophernandez@gmail.com"};
		mail.setTo(dest);
		mailService.sendHtmlEmail(mail);

		return mail;
	}

	@PostMapping(value = "/sendemails")
	public Iterable<EmailDto> emailHtmlTemplate(@RequestBody List<EmailDto> emails)
			throws IOException, MessagingException {

		mailService.sendEmails(emails);

		return emails;
	}

}
