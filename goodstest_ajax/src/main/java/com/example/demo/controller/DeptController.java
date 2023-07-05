package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	private DeptDAO dao;
	
	
	@GetMapping("/listDept")
	@ResponseBody
	public List<DeptVO> list(){
		return dao.findAllDept();
	}
}
