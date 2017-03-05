package com.iquest.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailSenderImpl implements EmailSender{
	
	@Autowired
	private MailSender mailSender;
	
	public void sendMail(String to, String token) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		//message.setFrom("benjisavu@gmail.com");
		message.setTo(to);
		message.setSubject("Email validation");
		message.setText("Please click on the folowing link http://localhost:8080/signup/validation/" + token);
		mailSender.send(message);
	}

}
