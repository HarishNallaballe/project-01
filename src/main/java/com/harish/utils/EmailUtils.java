package com.harish.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender emailSender;
	
	public boolean sendEmail(String subject,String body,String to) {
		boolean flag=false;
		try {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		helper.setTo(to);
		helper.setText(body);
		helper.setSubject(subject);
		emailSender.send(message);
		flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
