package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dao.MemberDAO;

import lombok.Setter;

@SpringBootApplication
@Setter
public class JpaBoard3Application {
	@Autowired
	private MemberDAO dao;
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(JpaBoard3Application.class, args);
	}

}
