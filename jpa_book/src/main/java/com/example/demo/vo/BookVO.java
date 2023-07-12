package com.example.demo.vo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="book")
public class BookVO {
	@Id
	private int bookid;
	private String bookname;
	private String publisher;
	private Integer price;
	
	//eager: 즉시 읽어옴 lazy: 나중에 읽어옴 
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	private List<OrdersVO> orders;
	
	
	
}
