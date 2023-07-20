package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.BoardDAO;
import com.example.demo.dao.ReplyDAO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.entity.Reply;
import com.example.demo.vo.ReplyVO;

import lombok.Setter;

@Controller
@Setter
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private ReplyDAO replyDAO;

	@GetMapping("/board/reply")
	@ResponseBody
	public ArrayList<ReplyVO> reply(int no){
		ArrayList<ReplyVO> arr = new ArrayList<ReplyVO>();
		System.out.println("/board/reply get방식 동작함!");
		
		List<Reply> list = replyDAO.findByNo(no);
		for(Reply r:list) {
			ReplyVO v = new ReplyVO();
			
			v.setCno(r.getCno());
			v.setB_ref(r.getB_ref());
			v.setB_level(r.getB_level());
			v.setB_step(r.getB_step());
			v.setContent(r.getContent());
			v.setRegdate(r.getRegdate());
			v.setId(r.getMember().getId());
			arr.add(v);
		}
		return arr;
	}
	
	@PostMapping("/board/reply")
	@ResponseBody
	public String reply(int no, String writer, String content, int cno) {		
		//일단 최초의 댓글이라고 본다.
		int new_cno = replyDAO.getNextCno();
		int b_ref = new_cno;
		int b_level = 0;
		int b_step = 0;
		
		//만약 댓글에 댓글이라면
		if(cno != 0) {
			Reply p = replyDAO.findById(cno).get();
			b_ref = p.getB_ref();
			b_step = p.getB_step();
			b_level = p.getB_level();
			
			replyDAO.updateStep(b_ref, b_step);
			
			b_step++;
			b_level++;
		}
		
		Reply r = new Reply();
		r.setCno(new_cno);
		r.setB_ref(b_ref);
		r.setB_level(b_level);
		r.setB_step(b_step);
		r.setContent(content);
		r.setRegdate(new Date());
		Board b = new Board();
		b.setNo(no);
		Member m = new Member();
		m.setId(writer);
		r.setMember(m);
		r.setBoard(b);
		replyDAO.save(r);
		return "OK";
	}
	
	
	@GetMapping("/board/detail/{no}")
	public String detail(@PathVariable("no") int no, 
			Model model) {		
		model.addAttribute("b", dao.findById(no).get());
		return "/board/detail";
	}
	
	@GetMapping("/board/insert")
	public void insert() {		
	}
	
	@PostMapping("/board/insert")	
	public String insert(Board b) {
		b.setRegdate(new Date());
		dao.save(b);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list")
	public void list(Model model) {
		System.out.println("게시물 목록 컨트롤러 동작함");
		model.addAttribute("list", dao.findAll());
	}
}