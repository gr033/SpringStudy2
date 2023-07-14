package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Account;

@Service
public class AccountService {
	@Autowired
	private AccountDAO dao;
	
	public Account findAccount(String a_email) {
		System.out.println(a_email);
		Account ac = null;
		if(dao.findByEmail(a_email) != null) {
			ac = dao.findByEmail(a_email);
		}
		return ac;
	}
}
