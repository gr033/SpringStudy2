package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BookVO;

public class DBManager {
	public static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/example/demo/db/dbConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("DBManager error: "+e.getMessage());
		}
	}
	
	public static List<BookVO> findAll() {
		List<BookVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("book.findAll");
		session.close();
		return list;
	}
	
	public static BookVO findByNo(int bookid) {
		BookVO b = null;
		SqlSession session = sqlSessionFactory.openSession();
		b = session.selectOne("book.findByNo", bookid);
		session.close();
		return b;
	}
}