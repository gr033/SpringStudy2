package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data	
@Table(name = "coding_test")
public class Coding_Test {
	@Id
	private int ct_no;
	@ManyToOne
	@JoinColumn(name = "a_no", insertable = true, updatable = true)
	private Account account;
	private String p_title;
	private String p_level;
	private String p_timer;
	private String p_time;
	private String p_memory;
	private String p_code;
	private String p_content;
	private Date p_date;
	private String p_lang;
}
