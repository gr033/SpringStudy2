package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CommonUtil;

@RestController
public class MemberController {
	
	@Autowired
	private CommonUtil util;
	
	@GetMapping("/listMember")
	public String list() {
		util.pro();
		return "회원 목록";
	}
}
