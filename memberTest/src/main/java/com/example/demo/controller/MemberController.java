package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/member/list")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
	@PostMapping("/member/insert")
	public ModelAndView insert(MemberVO m) {
		ModelAndView mav = new ModelAndView("redirect:/member/list");
		if(dao.insert(m) != 1) {
			mav.addObject("msg", "insert 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/member/insert")
	public void insertForm() {
	}
}
