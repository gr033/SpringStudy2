package com.example.demo.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.youiwe.webservice.BitSms;

@Controller
public class SmsController {
	
	@GetMapping("/sendMessage")
	@ResponseBody
	public String sendMessage() {
		Random random = new Random();
		int a = random.nextInt(10);
		int b = random.nextInt(10);
		int c = random.nextInt(10);
		int d = random.nextInt(10);
		
		String data = a+""+b+""+c+""+d;
		
		String from = "01025598279";
		String to = "01089879721";
		String msg = "인증번호: "+data;
		BitSms.sendMsg(from, to, msg);
		return "OK";
	}
	
}
