package com.example.demo.controller;


import java.io.File;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

@RequestMapping("/deleteBoard")
@Controller
@Setter
public class DeleteBoardController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping(method = RequestMethod.GET)
	public void form(int no, Model model) {
		model.addAttribute("no", no);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(int no, int pwd, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		HashMap<String, Object> map = new HashMap<>();
		BoardVO b = dao.findByNo(no);
		String fname = b.getFname();
		String path = request.getServletContext().getRealPath("upload");
		
		map.put("no", no);
		map.put("pwd", pwd);
		int re = dao.delete(map);
		if(re==1) {
			File file = new File(path+"/"+fname);
			file.delete();
		}else {
			mav.addObject("msg", "삭제에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
}	
