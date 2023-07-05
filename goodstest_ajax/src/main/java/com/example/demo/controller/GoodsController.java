package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsDAO dao;
	
	@GetMapping("/listGoods")
	@ResponseBody	//view로 이동하는 것이 아니라 ajax통신으로 호출되어 데이터 응답
	public List<GoodsVO> list(){
		return dao.findAll();
	}
}
