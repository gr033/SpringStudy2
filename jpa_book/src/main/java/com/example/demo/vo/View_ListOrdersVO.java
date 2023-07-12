package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "view_listorders")
public class View_ListOrdersVO {
	@Id
	private int orderid;
	
	private String name;
	private String bookname;
	private Date orderdate;
	private int saleprice;
	private int price;
}
