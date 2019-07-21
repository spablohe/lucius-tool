package es.usal.tfm.lucius.mail.service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import es.usal.tfm.lucius.mail.dto.EmailDto;

public interface IMailService {
	
	public EmailDto sendEmail(EmailDto emailDto) throws MessagingException, IOException;
	
	public EmailDto sendTextTemplateEmail(EmailDto emailDto) throws IOException, MessagingException;
	
	public EmailDto sendHtmlEmail(EmailDto emailDto) throws MessagingException, IOException;
	
	public List<EmailDto> sendEmails(List<EmailDto> emailDtos) throws MessagingException, IOException;

}
