package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MailSender mailsender;
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("/login")
	public void loginForm() {
	}
	
	@PostMapping("/login")
	public ModelAndView loginSubmit(String id, String pwd, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		boolean re = dao.isMember(map);
		if(re) {
			session.setAttribute("id", id);
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@GetMapping("/join")
	public void joinForm() {
	}
	
	
	@PostMapping("/join")
	public ModelAndView joinSubmit(MemberVO m) {
		int re = dao.insert(m);
		ModelAndView mav = new ModelAndView("redirect:/login");
		if(re != 1) {
			mav.addObject("msg", "회원가입에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/validEmail")
	@ResponseBody
	public String validEmail(String email) {
		int dat = (int)(Math.random() * 8999) + 1000;
		System.out.println(dat);
		String data = Integer.toString(dat);
		
		System.out.println(data);
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("yuri98834@gmail.com");
		mailMessage.setTo(email);
		mailMessage.setSubject("이메일 인증번호");
		mailMessage.setText("이메일 인증번호: "+data);
		try {
			mailsender.send(mailMessage);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("validEmail error: "+e.getMessage());
		}
		return data;
	}
	
	
}
