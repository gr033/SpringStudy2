package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CommonUtil;

import lombok.Setter;

@Setter
@RestController
public class BoardController {
	
	@Autowired
	private CommonUtil util;
	
	
	
	@GetMapping("/listBoard")
	public String list() {
		util.pro();
		return "게시물 목록";
	}
}
