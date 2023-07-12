package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	public List<BoardVO> findAll(){
		return dao.findAll();
	}
	
	public void save(BoardVO b) {
		dao.save(b);
	}
	
	public void delete(int no) {
		dao.deleteById(no);
	}
	
	public BoardVO getOne(int no) {
		return dao.getOne(no);
	}
	
}
