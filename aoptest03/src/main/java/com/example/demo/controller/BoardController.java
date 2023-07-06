package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class BoardController {
	
	@GetMapping("/listBoard")
	public String list(HttpServletRequest request) {
		
		return "게시물 목록";
	}
}
