package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVO;

@SpringBootApplication
public class Securitytest02Application {

	public static void main(String[] args) {
		
		/*
		 * MemberVO kim = new MemberVO(); kim.setId("kim");
		 * kim.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(
		 * "1234")); kim.setName("김유신"); kim.setRole("user");
		 * 
		 * MemberVO lee = new MemberVO(); lee.setId("lee");
		 * lee.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(
		 * "lee")); lee.setName("이순신"); lee.setRole("admin");
		 * 
		 * DBManager.insertMember(kim); DBManager.insertMember(lee);
		 * System.out.println("두 명의 멤버 추가");
		 */
		
		
		SpringApplication.run(Securitytest02Application.class, args);
	}
}
