package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVO;

public class DBManager {
	public static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("DBManager error: "+e.getMessage());
		}
	}
	
	public static int insert(GoodsVO g) {
		int re= -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("goods.insert", g);
		session.close();
		return re;
	}
	
	public static int update(GoodsVO g) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("goods.update", g);
		session.close();
		return re;
	}
	
	public static List<GoodsVO> findAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<GoodsVO> list = session.selectList("goods.findAll");
		session.close();
		return list;
	}
	
	public static GoodsVO detail(int no) {
		GoodsVO g = null;
		SqlSession session = sqlSessionFactory.openSession();
		g = session.selectOne("goods.detail", no);
		session.close();
		return g;
	}
	
	public static int delete(int no) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.delete("goods.delete",no);
		return re;
	}
}