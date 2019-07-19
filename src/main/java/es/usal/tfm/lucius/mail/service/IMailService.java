package es.usal.tfm.lucius.mail.service;

import java.io.IOException;

import javax.mail.MessagingException;

public interface IMailService {
	
	public void sendEmail();
	
	public void sendEmailWithAttachment() throws MessagingException, IOException;

}
