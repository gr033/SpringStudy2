package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

import jakarta.transaction.Transactional;
@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {
	@Modifying
	@Query(value = "select * from Account a where a.a_email = ?1", nativeQuery = true)
	@Transactional
	public Account findByEmail(String a_email);
	
	
}
