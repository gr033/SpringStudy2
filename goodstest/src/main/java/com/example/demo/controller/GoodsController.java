package com.example.demo.controller;

import java.io.File;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GoodsController {
	private GoodsDAO dao;
	
	@Autowired
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@GetMapping("/listGoods")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
	@GetMapping("/deleteGoods")
	public ModelAndView delete(int no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listGoods");
		
		//이미지가 있는 실제 경로를 알아온다.
		String path = request.getServletContext().getRealPath("images");
		
		//삭제할 상품의 파일명을 알아와 저장
		String fname = dao.detail(no).getFname();
		
		try {
			int re = dao.delete(no);
			if(re == 1) {
				File file = new File(path+"/"+fname);
				file.delete();
			}
		} catch (Exception e) {
			// TODO: handle exception
			mav.addObject("msg", "상품 삭제에 실패하였습니다.");
			mav.setViewName("error");
			System.out.println("delete error: "+e.getMessage());
		}
		
		return mav;
	}
}
