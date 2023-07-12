package com.example.demo.service;


import java.lang.reflect.Method;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.View_ListOrdersDAO;
import com.example.demo.vo.View_ListOrdersVO;

import lombok.Setter;

@Service
@Setter
public class View_ListOrdersService {
	@Autowired
	private View_ListOrdersDAO dao;
	
	public List<View_ListOrdersVO> findAll(String cname, String keyword, String sname){
		List<View_ListOrdersVO> list= null;
		String methodName = "find";
		if(keyword != null && !keyword.equals("")) {
			methodName += "By"+cname;
		}else {
			methodName += "All";
			if(sname != null && !sname.equals("")) {
				methodName += "By";
			}
		}
		
		if(sname != null && !sname.equals("")) {
			methodName += "OrderBy"+sname;
		}
		
		System.out.println("메소드명:"+methodName);

		//문자열로 된 자바메소드를 실행시키려면
		//다음과 같이하세요!
		//예를 들어 dao객체가 속해 있는 메소드를 실행하려면
		//다음과 같이 합니다.
		try {
			
			//그 메소드가 속해 있는 클래스의 이름에 해당하는
			//Class객체를 생성합니다.
			Class<?> cls = 
					Class.forName(dao.getClass().getName());
						
			Method m = null;
			if(keyword != null && !keyword.equals("")) {
				m = cls.getDeclaredMethod(methodName, String.class);
				list =(List)m.invoke(dao, keyword);
			}else {
				m = cls.getDeclaredMethod(methodName);
				list =(List)m.invoke(dao);
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return list;
	}
}