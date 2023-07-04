package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@Setter
public class MailController {
	@Autowired
	private MailSender mailSender;
	
	@GetMapping("/sendMail")
	@ResponseBody
	public String mail() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		Random random = new Random();
		int a = random.nextInt(10);
		int b = random.nextInt(10);
		int c = random.nextInt(10);
		int d = random.nextInt(10);
		
		String data = a+""+b+""+c+""+d;
		mailMessage.setFrom("yuri98834@gmail.com");
		mailMessage.setTo("yampt1111@gmail.com");
		//제목
		mailMessage.setSubject("비정상적인 활동이 감지 되었습니다.");
		//내용
		mailMessage.setText(data);
		
		try {
			mailSender.send(mailMessage);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("MailController error: "+e.getMessage());
		}
		return "OK";
	}
	
	
}
