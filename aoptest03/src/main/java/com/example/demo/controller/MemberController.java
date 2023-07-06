package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MemberController {
	
	@GetMapping("/listMember")
	public String list(HttpServletRequest request) {
		return "회원 목록";
	}
}
