package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	private DeptDAO dao;

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listDept")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		mav.setViewName("listDept");
		return mav;
	}
	
	//@RequestMapping(value="/insertDept", method=RequestMethod.GET)
	@GetMapping("/insertDept")
	public void insertForm() {
		ModelAndView mav = new ModelAndView();
		
	}
	
	//@RequestMapping(value="/insertDept", method=RequestMethod.POST)
	@PostMapping("/insertDept")
	public ModelAndView insertSubmit(DeptVO d) {
		ModelAndView mav = new ModelAndView("insertDeptOK");
		int re = dao.insert(d);
		String msg="부서등록에 성공하였습니다.";
		 if(re != 1) {
			 msg = "부서등록에 실패하였습니다.";
		 }
		 mav.addObject("msg", msg);
		return mav;
	}
}
