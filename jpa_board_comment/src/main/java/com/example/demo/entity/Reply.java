package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "reply")
public class Reply {
	
	@Id
	private int cno;
	
	@ManyToOne
	@JoinColumn(name = "no", insertable = true, updatable = true)
	private Board board;

	private String content;
	private Date regdate;
	private int b_ref;
	private int b_level;
	private int b_step;
	
	@ManyToOne
	@JoinColumn(name = "id", insertable = true, updatable = true)
	private Member member;
}