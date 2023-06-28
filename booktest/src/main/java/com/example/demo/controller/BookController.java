package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;

@Controller
public class BookController {
	
	@Autowired
	private BookDAO dao;
	
	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/detailBook")
	public void detail(int bookid, Model model) {
		model.addAttribute("b", dao.detailBook(bookid));
	}
	
	@RequestMapping("/listBook")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		mav.setViewName("listBook");
		return mav;
	}
	
	@GetMapping("/insertBook")
	public void insert(Model model) {
		model.addAttribute("bookid", dao.getNextBookId());
	}
	
	@PostMapping("/insertBook")
	public ModelAndView submit(BookVO b) {
		ModelAndView mav = new ModelAndView();
		int re = dao.insert(b);
		if(re == 1) {
			mav.setViewName("redirect:/listBook");
		}else {
			mav.setViewName("error.jsp");
			mav.addObject("msg", "도서등록에 실패하였습니다.");
		}
		return mav;
	}
	
	@GetMapping("/updateBook")
	public void updateForm(int bookid, Model model) {
		model.addAttribute("b",dao.detailBook(bookid));
	}
	
	@PostMapping("/updateBook")
	public ModelAndView updateSubmit(BookVO b) {
		ModelAndView mav = new ModelAndView("redirect:/detailBook?bookid="+b.getBookid());
		int re = dao.updateBook(b);
		if(re != 1) {
			mav.addObject("msg", "도서수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping("/deleteBook")
	public ModelAndView deleteForm(int bookid) {
		ModelAndView mav = new ModelAndView("redirect:/listBook");
		int re = dao.deleteBook(bookid);
		if(re != 1) {
			mav.addObject("msg", "도서삭제에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
}	