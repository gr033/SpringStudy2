package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/updateGoods")
public class UpdateGoodsController {

	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form(int no, Model model) {
		model.addAttribute("g", dao.detail(no));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(GoodsVO g, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listGoods");
		String path = request.getServletContext().getRealPath("images");
		
		//원래 사진이름을 저장할 변수
		String oldFname;
		
		//원래 사진 이름을 저장
		oldFname = g.getFname();
		
		//업로드한 파일 객체를 담아온다.
		MultipartFile uploadFile = g.getUploadFile();
		
		//업로드한 파일명을 담기 위한 변수
		String fname = null;
		
		//업로드한 파일이름을 저장
		fname = uploadFile.getOriginalFilename();
		
		//만약 업로드한 파일이 있다면 그것을 저장하고 vo에도 담아준다.
		if(fname != null && !fname.equals("")) {
			
			//중복된 파일 이름을 피하기 위하여 임의의 난수를 발생하여 파일이름 뒤에 붙여준다.
			long n = System.currentTimeMillis();

			String fname1 = fname.substring(0, fname.lastIndexOf("."));
			String fname2 = fname.substring(fname.lastIndexOf("."));
			
			System.out.println(fname1);
			System.out.println(fname2);
			
			fname = fname1 + n + fname2;
			
			System.out.println(fname);
			System.out.println("업로드 파일 있음");
			
			
			//파일의 내용을 가지고 온다.
			try {
				int re = dao.update(g);
				
				if(re==1 && fname!= null && !fname.equals("")) {
					try {
						byte[] data = uploadFile.getBytes();
						
						//파일을 저장하기 위한 스트림을 생성
						FileOutputStream fos = new FileOutputStream(path+"/"+fname);
						
						//파일로 내용을 출력
						fos.write(data);
						fos.close();
						
						//업로드한 파일이름을 vo에 저장
						g.setFname(fname);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("UpdateGoodsController error: "+e.getMessage());
					}
				}
				File file = new File(path+"/"+oldFname);
				file.delete();
		} catch (Exception e) {
			// TODO: handle exception
			mav.addObject("msg", "상품 수정에 실패하였습니다.");
			mav.setViewName("error");
			}
		}	
		return mav;
	}
}