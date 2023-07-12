package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BookService;
import com.example.demo.vo.BookVO;

import lombok.Setter;

@Controller
@Setter
public class BookController {
	@Autowired
	private BookService bs;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = {"/book/list/{cname}/{keyword}",
			"/book/list/{cname}/",
			"/book/list"})
	public ModelAndView list(
			@PathVariable(required = false) String cname,
			@PathVariable(required = false) String keyword) {
		ModelAndView mav = 
				new ModelAndView("/book/list");
		mav.addObject("list", bs.findAll(cname,keyword));
		return mav;

	}
	
	@GetMapping("/book/insert")
	public void insert() {		
	}
	
	@PostMapping("/book/save")
	public ModelAndView save(BookVO b) {
		ModelAndView mav = new ModelAndView("redirect:/book/list");
		bs.save(b);
		return mav;
	}
	
	@GetMapping("/book/update/{bookid}")
	public ModelAndView update(@PathVariable int bookid) {
		ModelAndView mav = new ModelAndView("/book/update");
		
		mav.addObject("b", bs.getOne(bookid));
		return mav;
	}
	
	@GetMapping("/book/delete/{bookid}")
	public ModelAndView delete(@PathVariable int bookid) {
		ModelAndView mav = new ModelAndView("redirect:/book/list");
		bs.deleteById(bookid);
		return mav;
	}
}