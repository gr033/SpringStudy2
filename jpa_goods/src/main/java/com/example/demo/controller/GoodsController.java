package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.GoodsService;
import com.example.demo.vo.GoodsVO;

import lombok.Setter;

@Controller
@Setter
public class GoodsController {
	@Autowired
	private GoodsService gs;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/goods/insert")
	public void insert() {
	}
	
	@GetMapping("/goods/list")
	public void list(Model model) {
		model.addAttribute("list", gs.findAll());
	}
	
	@PostMapping("/goods/save")
	public ModelAndView save(GoodsVO g) {
		ModelAndView mav = new ModelAndView("redirect:/goods/list");
		gs.save(g);
		return mav;
	}
	
	@GetMapping("/goods/update")
	public void update(int no, Model model) {
		model.addAttribute("g", gs.getOne(no));
	}
	
	@GetMapping("/goods/delete")
	public ModelAndView delete(int no) {
		ModelAndView mav = new ModelAndView("redirect:/goods/list");
		gs.delete(no);
		return mav;
	}
	
}
