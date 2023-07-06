package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller+ResponseBody
@RestController
public class BoardController {
	
	@GetMapping("/listBoard")
	public String list() {
		
		return "게시물 목록";
	}
}
