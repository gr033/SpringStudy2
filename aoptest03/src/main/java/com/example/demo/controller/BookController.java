package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.BookDAO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

@Setter
@Controller
public class BookController {
	@Autowired
	private BookDAO dao;
	
	@RequestMapping("/listBook")
	public void list(HttpServletRequest request, Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
	@RequestMapping("/detailBook")
	public void detail(HttpServletRequest request, int bookid, Model model) {
		model.addAttribute("b", dao.findByNo(bookid));
	}
}
