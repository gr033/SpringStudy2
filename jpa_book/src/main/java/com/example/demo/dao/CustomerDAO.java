package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.CustomerVO;

public interface CustomerDAO extends JpaRepository<CustomerVO, Integer> {
	public List<CustomerVO> findAllByOrderByCustid(); 
}
