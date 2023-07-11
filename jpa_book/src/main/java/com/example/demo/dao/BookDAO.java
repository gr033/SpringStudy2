package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.vo.BookVO;

public interface BookDAO extends JpaRepository<BookVO, Integer> {
//	public List<BookVO> findAllOrderByBookName();
	
	@Query("select b from BookVO b order by b.bookname")
	public List<BookVO> selectAll();
	
	public List<BookVO> findAllByOrderByBookname();
	
	public List<BookVO> findByBookidLikeOrderByPriceDesc(int bookid);
	public List<BookVO> findByBooknameLikeOrderByPriceDesc(String bookname);
	public List<BookVO> findByPublisherLikeOrderByPriceDesc(String publisher);
	public List<BookVO> findByPriceLikeOrderByPriceDesc(int Price);
	
	
}