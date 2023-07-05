package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.youiwe.webservice.BitSms;

@Controller
public class SmsController {
	
	@GetMapping("/sendMessage")
	@ResponseBody
	public String sendMessage() {
		String from = "01025598279";
		String to = "01089879721";
		String msg = "아시안컵 결승\r\n";
		BitSms.sendMsg(from, to, msg);
		return "OK";
	}
	
}
