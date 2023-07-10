package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

@Service
public class BookService {
	@Autowired
	private BookDAO dao;
	
	public List<BookVO> findAll(){
		return dao.selectAll();
//		return dao.findAll();
	}
	
	public void save(BookVO b) {
		dao.save(b);
	}
	
	public BookVO getOne(int bookid) {
		return dao.getOne(bookid);
	}
	
	public void deleteById(int bookid) {
		dao.deleteById(bookid);
	}
}
