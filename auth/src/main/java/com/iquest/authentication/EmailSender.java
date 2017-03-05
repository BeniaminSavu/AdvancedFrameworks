package com.iquest.authentication;

public interface EmailSender {

	void sendMail(String to, String token);
}
