package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.GoodsDAO;

@Controller
@RequestMapping("/detailGoods")
public class DetailGoodsController {
	
	@Autowired
	private GoodsDAO dao;
	
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void form() {
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void submit(int no, Model model) {
		model.addAttribute("g", dao.detail(no));
	}
	
}
