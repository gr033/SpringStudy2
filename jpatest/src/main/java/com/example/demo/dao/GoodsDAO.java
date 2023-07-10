package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.GoodsVO;

public interface GoodsDAO extends JpaRepository<GoodsVO, Integer> {
	
}
