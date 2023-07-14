package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.entity.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	public int deleteBoard(int no, String pwd) {
		return dao.deleteBoard(no, pwd);
	}
	
	//전체 레코드 수를 반환하는 메소드정의
	public int getTotalRecord() {
		return (int)dao.count();
	}
	
	public List<Board> findAll(int start, int end){
		return dao.selectAll(start, end);
	}
	
	public List<Board> findWriter(int start, int end, String writer){
		return dao.selectWriter(start, end, writer);
	}
	
	public void save(Board b) {
		dao.save(b);
	}
	
	public void delete(int no) {
		dao.deleteById(no);
	}
	
	public Board findById(int no) {
		return dao.findById(no).get();
	}
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	public void insert(Board b) {
		dao.insert(b);
	}
	
	public void updateStep(int b_ref, int b_step) {
		dao.updateStep(b_ref, b_step);
	}
	
	public int selectWriter(String writer) {
		return dao.countWriter(writer);
	}
	
}
