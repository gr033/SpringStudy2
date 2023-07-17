package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebtoolController {
	
	@GetMapping("/saveImg")
	public String saveImg() {
		String addr = "https://shared-comic.pstatic.net/thumb/webtoon/758037/thumbnail/thumbnail_IMAG21_15cb2611-34c0-4f02-a689-41d0b1016579.jpg";
		try {
			String path = "c:/data";
			URL url = new URL(addr);
			InputStream is = url.openStream();
			String fname = "참교육.jpg";
			FileOutputStream fos = new FileOutputStream(path+"/"+fname);
			FileCopyUtils.copy(is.readAllBytes(), fos);
			is.close();
			fos.close();
			System.out.println("파일에 저장하였습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("saveImg error: "+e.getMessage());
		}
		return "OK";
	}
	
	@GetMapping("/allImageDown")
	public String allImageDown() {
		String url = "https://www.hanbit.co.kr/store/books/new_book_list.html";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements list = doc.select("#container > div.component_wrap.type2 > div.WeekdayMainView__daily_all_wrap--UvRFc").get(0).getElementsByTag("img");
			System.out.println(list);
			for(Element img : list) {
				String src = img.attr("src");
				String title = img.attr("title");
				System.out.println("src: "+src+", title: "+title);
				System.out.println("-----------------------------------");
				downloadImage(src, title);
			}
			System.out.println("모두 다운로드하였습니다.");
		}catch (Exception e) {
	         System.out.println("예외발생:"+e.getMessage());
	    }
	    return "OK";
	}
	
	public static void downloadImage(String addr, String fname) {      
		try {
			String path = "c:/data";
			 
			fname=fname.replace("?", "");
			fname=fname.replace(":", "");
			 
			FileOutputStream fos = new FileOutputStream(path + "/" + fname+".jpg");
			URL url = new URL(addr);
			InputStream is = url.openStream();
			FileCopyUtils.copy(is.readAllBytes(), fos);
			fos.close();
			System.out.println(fname+"을 저장하였습니다.");
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
