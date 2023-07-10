package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.GoodsService;

import lombok.Setter;

@Controller
@Setter
public class GoodsController {
	
	@Autowired
	private GoodsService gs;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", gs.findAll());
	}
}
