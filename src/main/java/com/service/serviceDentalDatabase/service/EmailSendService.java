//Email Sending Service
package com.service.serviceDentalDatabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {
	//Wiring
	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toEmail,
			String body,
			String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		//Sending Text Message
		message.setFrom("insuranceimpetus1@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail Send...");


	}
}

