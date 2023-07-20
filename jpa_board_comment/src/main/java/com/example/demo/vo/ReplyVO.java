package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	int cno;
	int b_ref;
	int b_level;
	int b_step;
	String content;
	Date regdate;
	String id;
}