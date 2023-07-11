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
@Table(name="customer")
public class CustomerVO {
	@Id
	private int custid;
	private String name;
	private String address;
	private String phone;
	private String fname;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<OrdersVO> orders;
}
