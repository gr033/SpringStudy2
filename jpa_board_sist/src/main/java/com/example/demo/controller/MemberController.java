package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	
	@GetMapping("/member/login")
	public void login() {
	}
	
}
