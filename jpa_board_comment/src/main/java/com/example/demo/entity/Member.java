package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member {
	@Id
	private String id;
	private String pwd;
	private String name;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Board> boards;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Reply> replies;
}