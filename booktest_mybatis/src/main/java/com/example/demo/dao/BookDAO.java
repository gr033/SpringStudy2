package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BookVO;

@Repository
public class BookDAO {
	
	public List<BookVO> findAll(HashMap<String, Object> map){
		return DBManager.findAll(map);
	}
	
	public int insert(BookVO b) {
		return DBManager.insert(b);
	}
	
	public BookVO findByBookId(int bookid) {
		return DBManager.findByBookId(bookid);
	}
	
	public int update(BookVO b) {
		return DBManager.update(b);
	}
	
	public int delete(int bookid) {
		return DBManager.delete(bookid);
	}
}
