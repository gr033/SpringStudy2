package com.example.demo.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVO;

@Repository
public class MemberDAO {
	public static int insert(MemberVO m) {
		return DBManager.insertMember(m);
	}
	
	public boolean isMember(HashMap<String, Object> map) {
		return DBManager.isMember(map);
	}
}
