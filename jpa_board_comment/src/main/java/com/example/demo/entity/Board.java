package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "board")
@SequenceGenerator(
	name="SEQ_BOARD_GEN",
	sequenceName = "SEQ_BOARD",
	initialValue = 1,
	allocationSize = 1
)
public class Board {
	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "SEQ_BOARD_GEN"
	)
	private int no;
	private String title;
	private String writer;
	private String content;
	
	@Column(nullable = false, columnDefinition = "date default sysdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	private List<Reply> replies;
	
	@ManyToOne
	@JoinColumn(name = "id", insertable = true, updatable = true)
	private Member member;
}