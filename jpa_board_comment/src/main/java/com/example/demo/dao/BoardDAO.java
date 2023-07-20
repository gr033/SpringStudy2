package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Board;

import jakarta.transaction.Transactional;
@Repository
public interface BoardDAO extends JpaRepository<Board, Integer> {
	@Transactional
	@Modifying
	@Query(value = "insert into Board b(b.no, b.title, b.writer, b.content, b.regdate) "
			+ "values(seq_board.nextval, :#{#b.title}, :#{#b.writer}, :#{#b.content}, sysdate)", nativeQuery = true)
	public void insert(Board b);
	
}
