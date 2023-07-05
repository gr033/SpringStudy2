package com.example.demo.controller;

import java.io.FileOutputStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;
import com.sist.util.MyUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

@RequestMapping("/insertBoard")
@Controller
@Setter
public class InsertBoardController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public void form(@RequestParam(value = "no", defaultValue = "0") int no, Model model) {
		//no
		//답글이면 부모글의 글번호
		//새글이면 0
		model.addAttribute("no", no);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(BoardVO b, HttpServletRequest request) {
		int no = dao.getNextNo();
		//답글 쓰기와 관련한 세개의 칼럼에 대한 값을 설정
		//일단 새 글이라 본다.
		
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;
		
		//답글인지 확인
		int pno = b.getNo();
		if(pno != 0) {
			BoardVO p = dao.findByNo(pno);
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();
			
			HashMap<String, Object> map = new HashMap<>();
			
			map.put("b_ref", b_ref);
			map.put("b_step", b_step);
			dao.updateStep(map);
			
			b_level++;
			b_step++;
		}
		
		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		
		String path = request.getServletContext().getRealPath("upload");
		System.out.println("path: "+path);
		
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		
		String fname = null;
		MultipartFile uploadFile = b.getUploadFile();
		System.out.println("uploadFile:"+uploadFile);
		
		fname = uploadFile.getOriginalFilename();
		
		//업로드 파일이 없을 때 ""을 설정
		b.setFname("");
		
		//업로드 파일이 있다면
		if(fname != null && !fname.equals("")) {
			fname = MyUtil.getRenameNotMultiple(fname);
			b.setFname(fname);
		}
		
		try {
			int re = dao.insert(b);
			if(re==1) {
				if(fname != null && !fname.equals("")) {
					try {
						byte []data = uploadFile.getBytes();
						FileOutputStream fos = new FileOutputStream(path+"/"+fname);
						fos.write(data);
						fos.close();
						
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("file insert error: "+e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			mav.addObject("msg", "게시물 등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
}
