package com.example.demo.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.BoardDAO;

@Controller
public class BoardController {
	@Autowired
	public BoardDAO dao;

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listBoard")
	public void list(Model model, @RequestParam(value = "pageNUM", defaultValue = "1") int pageNUM) {
		int start = (pageNUM-1)*dao.pageSIZE+1;
		int end = start + dao.pageSIZE-1;
		//findAll을 호출 해야지만 totalRecord가 계산이 된다.
		//계산되기 전에 기본값은 0이기 때문에 바람직한 end가 구해지지 않는다.
		HashMap<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		model.addAttribute("list", dao.findAll(map));
		model.addAttribute("totalPage", dao.totalPage);
	}
	
	@RequestMapping("/detailBoard")
	public void detail(Model model, int no) {
		dao.updateHit(no);
		model.addAttribute("b", dao.findByNo(no));
	}
	
}
