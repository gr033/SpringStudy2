package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.MemberVO;

public class DBManager {
	public static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("DBManager error: "+e.getMessage());
		}
	}
	
	public static List<MemberVO> findAll(){
		List<MemberVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("member.findAll");
		session.close();
		return list;
	}
	
	public static int insert(MemberVO m) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("member.insert", m);
		session.close();
		return re;
	}
}
