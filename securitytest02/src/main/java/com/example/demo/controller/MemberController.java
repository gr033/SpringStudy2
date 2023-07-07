package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/join")
	public void joinForm() {
		
	}
	
	@PostMapping("/join")
	public ModelAndView joinSubmit(MemberVO m) {
		
		
		ModelAndView mav = new ModelAndView("redirect:/login");
		//String pwd = m.getPwd();
		//String encPwd = passwordEncoder.encode(pwd);
		//m.setPwd(encPwd);
		m.setPwd(passwordEncoder.encode(m.getPwd()));
		try {
			int re = dao.insert(m);
			if(re != 1) {
				mav.setViewName("error");
				mav.addObject("msg", "회원가입에 실패하였습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			mav.setViewName("error");
			mav.addObject("msg", "회원가입에 실패하였습니다.");
		}
		return mav;
	}
	
	@GetMapping("/login")
	public void login() {
	}
	
	@GetMapping("/service1")
	public void service1(HttpSession session) {
		//인증된(로그인한) 회원의 정보를 갖고 오기 위하여 
		//먼저 시큐리티의 인증 객체가 필요하다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		//이 인증객체를 통해서 인증된(로그인한) User객체를 받아온다.
		User user = (User)authentication.getPrincipal();
		
		//이 인증된 유저를 통해 로그인한 회원의 아이디를 갖고 온다.
		String id = user.getUsername();
		
		//이 정보를 session에 상태유지
		//만약 아이디 뿐만 아니라 로그인한 회원의 다른 정보도 필요하다면 
		//dao를 통해 회원의 정보를 갖고와서 상태유지
		session.setAttribute("id", id);
		
	}
	
}
