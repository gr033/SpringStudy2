package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.BoardVO;

public interface BoardDAO extends JpaRepository<BoardVO, Integer> {

}
