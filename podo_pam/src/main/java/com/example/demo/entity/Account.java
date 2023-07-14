package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account {
	@Id	
	private int a_no;
	private String a_nick;
	private String a_name;
	private String a_gender;
	private String a_email;
	private int img;
	private int a_regdate;
}
