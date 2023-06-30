package com.example.demo.controller;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/insertGoods")
public class InsertGoodsController {
	
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(GoodsVO g, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listGoods");
		//String path = request.getRealPath("images");
		String path = request.getServletContext().getRealPath("images");
		System.out.println(path);
		
		MultipartFile uploadFile = g.getUploadFile();
		
		//일단 파일명에 ""을 설정
		String fname=null;
		
		//업로드한 파일명을 fname변수에 저장
		fname=uploadFile.getOriginalFilename();
		
		if(fname != null && !fname.equals("")) {
			//업로드한 파일이 있다면 그 파일명을 설정
			
			//중복된 파일 이름을 피하기 위하여 임의의 난수를 발생하여 파일이름 뒤에 붙여준다.
			long n = System.currentTimeMillis();

			String fname1 = fname.substring(0, fname.lastIndexOf("."));
			String fname2 = fname.substring(fname.lastIndexOf("."));
			
			System.out.println(fname1);
			System.out.println(fname2);
			
			fname = fname1 + n + fname2;
			
			System.out.println("파일명:"+fname);
			System.out.println("업로드 파일 있음");
			g.setFname(fname);
		}
		
		try {
			int re = dao.insert(g);
			
			//db에 insert를 성공했을 때에 파일을 복사하도록 한다.
			if(re==1) {
				//만약 업로드 파일이 있다면
				if(fname != null && !fname.equals("")) {
					try {
						//파일의 내용을 바이트로 가지고 온다.
						byte []data = uploadFile.getBytes();
						
						//업로드한 파일이름을 가지고 온다.
//						fname = uploadFile.getOriginalFilename();
						
						//파일을 출력하기 위한 스트림을 생성
						FileOutputStream fos = new FileOutputStream(path+"/"+fname);
						
						//파일에 출력
						fos.write(data);
						fos.close();
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("submit error: "+e.getMessage());
					}
				}else {
					System.out.println("업로드 파일 없음");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("상품등록에 실패하였습니다.");
			mav.addObject("msg", "상품등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
}
