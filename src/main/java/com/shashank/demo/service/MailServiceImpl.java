package com.shashank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendMail(String to, String subject, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage mail= new SimpleMailMessage();
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(message);
		mailSender.send(mail);
		System.out.println("Mail sent...");
	}

}
