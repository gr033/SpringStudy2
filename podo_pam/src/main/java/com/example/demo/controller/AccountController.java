package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService as;
	
	@GetMapping("/index/{email}")
	public ModelAndView search(@PathVariable("email") String a_email) {
	System.out.println(a_email);
	ModelAndView mav = new ModelAndView("/ok");
	mav.addObject("a_email", a_email);
	return mav;
	}
	
	
}
