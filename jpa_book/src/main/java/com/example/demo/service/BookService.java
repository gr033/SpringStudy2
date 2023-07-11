package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

@Service
public class BookService {
	@Autowired
	private BookDAO dao;
	
	public List<BookVO> findAll(String column, String keyword){
		System.out.println(column);
		System.out.println(keyword);
		List<BookVO> list = null;
		if(keyword != null && !keyword.equals("") && !keyword.equals("all")) {
			if(column.equals("price")) {
				list = dao.findByPriceLikeOrderByPriceDesc(Integer.parseInt(keyword));
			}else if(column.equals("publisher")) {
				list = dao.findByPublisherLikeOrderByPriceDesc("%"+keyword+"%");
			}else if(column.equals("bookid")) {
				list = dao.findByBookidLikeOrderByPriceDesc(Integer.parseInt(keyword));
			}else if(column.equals("bookname")) {
				list = dao.findByBooknameLikeOrderByPriceDesc("%"+keyword+"%");
			}
		}else {
			list = dao.findAll();
		}
		return list;
//		return dao.findAllByOrderByBookname();
//		return dao.findAll();
//		return dao.selectAll();
	}
	
	public void save(BookVO b) {
		dao.save(b);
	}
	
	public BookVO getOne(int bookid) {
		return dao.getOne(bookid);
	}
	
	public void deleteById(int bookid) {
		dao.deleteById(bookid);
	}
}
