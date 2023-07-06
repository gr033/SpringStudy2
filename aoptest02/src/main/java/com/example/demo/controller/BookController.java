package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.CommonUtil;
import com.example.demo.dao.BookDAO;

import lombok.Setter;

@Setter
@Controller
public class BookController {
	@Autowired
	private BookDAO dao;
	
	@Autowired
	private CommonUtil util;
	
	@RequestMapping("/listBook")
	public void list(Model model) {
		util.pro();
		model.addAttribute("list", dao.findAll());
	}
	
	@RequestMapping("/detailBook")
	public void detail(int bookid, Model model) {
		util.pro();
		model.addAttribute("b", dao.findByNo(bookid));
	}
}
