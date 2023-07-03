package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BoardVO;

@Repository
public class BoardDAO {
	public List<BoardVO> findAll(){
		return DBManager.findAll();
	}
	
	public int insert(BoardVO b) {
		return DBManager.insert(b);
	}
	
	public BoardVO findByNo(int no) {
		return DBManager.findByNo(no);
	}
	
	public int getNextNo() {
		return DBManager.getNextNo();
	}
	
	public void updateHit(int no) {
		DBManager.updateHit(no);
	}
	
	public void updateStep(HashMap<String, Object> map) {
		DBManager.updateStep(map);
	}
	
	public int update(BoardVO b) {
		return DBManager.update(b);
	}
	
	public int delete(HashMap<String, Object> map) {
		return DBManager.delete(map);
	}
}