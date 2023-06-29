package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

@Controller
public class BookController {
	private BookDAO dao;
	
	@Autowired
	public void setDao(BookDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/listBook")
	public void list(Model model, String keyword, String keyfield, String cal) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("keyfield", keyfield);
		map.put("cal", cal);
		model.addAttribute("list", dao.findAll(map));
	}
	
	@PostMapping("/insertBook")
	public ModelAndView insertSubmit(BookVO b) {
		ModelAndView mav = new ModelAndView("redirect:/listBook");
		int re = dao.insert(b);
		if(re != 1) {
			mav.addObject("msg", "등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	@GetMapping("/insertBook")
	public void insertForm(BookVO b) {
		
	}
	
	@RequestMapping("/detailBook")
	public void detail(int bookid, Model model) {
		model.addAttribute("b", dao.findByBookId(bookid));
	}
	
	@PostMapping("/updateBook")
	public ModelAndView updateSubmit(BookVO b) {
		ModelAndView mav = new ModelAndView("redirect:/detailBook?bookid="+b.getBookid());
		int re = dao.update(b);
		if(re != 1) {
			mav.addObject("msg", "수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/updateBook")
	public void updateForm(int bookid, Model model) {
		model.addAttribute("b", dao.findByBookId(bookid));
	}
	
	@RequestMapping("/deleteBook")
	public ModelAndView delete(int bookid) {
		ModelAndView mav = new ModelAndView("redirect:/listBook");
		int re = dao.delete(bookid);
		if(re != 1) {
			mav.addObject("msg", "도서 삭제에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	/*
	@RequestMapping("/listBook")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		System.out.println("listBookController 동작");
		return mav;
	}
	*/
}