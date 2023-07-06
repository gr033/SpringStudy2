package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVO;

public class DBManager {
	public static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DBManager error: "+e.getMessage());
		}
	}
	
	public static List<DeptVO> findAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<DeptVO> list = null;
		list = session.selectList("dept.findAll");
		session.close();
		return list;
	}
	
	public static DeptVO findByDno(int dno) {
		SqlSession session = sqlSessionFactory.openSession();
		DeptVO d = null;
		d = session.selectOne("dept.findByDno", dno);
		session.close();
		return d;
	}
}
