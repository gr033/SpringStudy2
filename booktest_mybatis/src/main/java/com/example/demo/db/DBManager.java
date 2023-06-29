package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
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
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("DBManager error: "+e.getMessage());
		}
	}
	
	public static int insert(BookVO b) {
		int re = -1;
		//true값을 넣음으로써 자동 커밋을 해준다.
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("book.insert", b);
//		session.commit();
		session.close();
		return re;
	}
	
	public static List<BookVO> findAll(HashMap<String, Object> map){
		List<BookVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("book.findAll", map);
		session.close();
		return list;
	}
	
	public static BookVO findByBookId(int bookid) {
		BookVO b = null;
		SqlSession session = sqlSessionFactory.openSession();
		b = session.selectOne("book.findByBookId", bookid);
		session.close();
		return b;
	}
	
	public static int update (BookVO b) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("book.update", b);
		session.close();
		return re;
	}
	
	public static int delete (int bookid) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.delete("book.delete", bookid);
		session.close();
		return re;
	}
}
