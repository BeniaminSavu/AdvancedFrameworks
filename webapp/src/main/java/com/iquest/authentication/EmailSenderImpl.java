package com.iquest.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.iquest.constants.Email;

public class EmailSenderImpl implements EmailSender {

	@Autowired
	private MailSender mailSender;

	public void sendMail(String to, String token) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject(Email.SUBJECT);
		message.setText(Email.TEXT + token);
		mailSender.send(message);
	}

}
