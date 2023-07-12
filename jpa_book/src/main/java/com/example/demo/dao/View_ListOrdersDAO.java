package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.View_ListOrdersVO;

@Repository
public interface View_ListOrdersDAO extends JpaRepository<View_ListOrdersVO, Integer> {
	
	public List<View_ListOrdersVO>
	findByName(String name);

	//도서명으로 검색
	//select * from view_listorders where bookname= '재미있는 자바'
	public List<View_ListOrdersVO>
		findByBookname(String bookname);

   public List<View_ListOrdersVO> findByNameOrderByOrderid(String name);
   public List<View_ListOrdersVO> findByNameOrderByName(String name);
   public List<View_ListOrdersVO> findByNameOrderByBookname(String name);
   public List<View_ListOrdersVO> findByNameOrderByOrderdate(String name);
   public List<View_ListOrdersVO> findByNameOrderBySaleprice(String name);
   public List<View_ListOrdersVO> findByNameOrderByPrice(String name);
                              
   public List<View_ListOrdersVO> findByBooknameOrderByOrderid(String bookname);
   public List<View_ListOrdersVO> findByBooknameOrderByName(String bookname);
   public List<View_ListOrdersVO> findByBooknameOrderByBookname(String bookname);
   public List<View_ListOrdersVO> findByBooknameOrderByOrderdate(String bookname);
   public List<View_ListOrdersVO> findByBooknameOrderBySaleprice(String bookname);
   public List<View_ListOrdersVO> findByBooknameOrderByPrice(String bookname);
                              
                              
   public List<View_ListOrdersVO> findAllByOrderByOrderid();
   public List<View_ListOrdersVO> findAllByOrderByName();
   public List<View_ListOrdersVO> findAllByOrderByBookname();
   public List<View_ListOrdersVO> findAllByOrderByOrderdate();
   public List<View_ListOrdersVO> findAllByOrderBySaleprice();
   public List<View_ListOrdersVO> findAllByOrderByPrice();
}                             
