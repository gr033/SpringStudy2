package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BoardService;

import lombok.Setter;


@Controller
@Setter
public class BoardController {
	@Autowired 
	private BoardService bs;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", bs.findAll());
		return mav;
	}
	
}
