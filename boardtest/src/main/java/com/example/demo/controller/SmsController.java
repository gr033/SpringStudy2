package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.youiwe.webservice.BitSms;

@Controller
public class SmsController {
	
	@GetMapping("/sendMessage")
	public String sendMessage() {
		String from = "01025598279";
		String to = "01089879721";
		String msg = "아시안컵 결승\r\n"
				+ "한 VS 일\r\n"
				+ "\r\n"
				+ "점프와 함께 응원해요!\r\n"
				+ "10+5~300+50\r\n";
		try {
			BitSms.sendMsg(from, to, msg);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("이상 무"+e.getMessage());
		}
		return "OK";
	}
	
}
