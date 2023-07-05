package com.example.demo.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@Setter
public class HtmlMailController {
	
	@Autowired
	private JavaMailSender sender;
	
	@GetMapping("/sendHtmlEmail")
	@ResponseBody
	public String send() {
		sender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
				String text = "<h2>명세서</h2><br>"
						+ "<table border=\"1\">"
						+ "<tr>"
						+ "<th>이름</th>"
						+ "<th>급여</th>"
						+ "<th>수당</th>"
						+ "<th>실수령액</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<td>"
						+ ""
						+ ""
						+ ""
						+ "</tr>"
						+ "</table>";
				message.setFrom("yuri98834@gmail.com");
				message.setTo("gr033@naver.com");
				message.setSubject("HTML 형식의 이메일 전송");
			}
		});
		
		return "OK";
	}
}
