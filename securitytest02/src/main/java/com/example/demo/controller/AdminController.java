package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin/drink1")
	public void drink1() {
		System.out.println("admin 컨트롤러의 음료1 요청처리");
	}
	
	@GetMapping("/admin/drink2")
	public void drink2() {
		System.out.println("admin 컨트롤러의 음료2 요청처리");
	}
	
}
