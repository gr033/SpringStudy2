package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.vo.CustomerVO;

@Service
public class CustomerService {
	@Autowired
	private CustomerDAO dao;
	
	public List<CustomerVO> findAll(){
		return dao.findAll();
//		return dao.findAllByOrderByCustid();
	}
	
	public void save(CustomerVO b) {
		dao.save(b);
	}
	
	public void delete(int custid) {
		dao.deleteById(custid);
	}
	
	public CustomerVO getOne(int custid) {
		return dao.getOne(custid);
	}
	
}
