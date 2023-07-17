package com.example.demo.controller;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HanbController {
	
	@GetMapping("/downImg")
	public String downImg() {
		String addr = "https://www.hanbit.co.kr/data/books/B1230440130_m.jpg";
		String fname = "사실은 이것도 디자인입니다.jpg";
		try {
			URL url = new URL(addr);
			InputStream is = url.openStream();
			FileOutputStream fos = new FileOutputStream("c:/data/"+fname);
			FileCopyUtils.copy(is.readAllBytes(), fos);
			is.close();
			fos.close();
			System.out.println("이미지 다운 완료");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("downImg error: "+e.getMessage());
		}
		return "OK";
	}
	
	@GetMapping("/newBook")
	public String newBook(){
		String url = "https://www.hanbit.co.kr/store/books/new_book_list.html";

		try {
			Document doc = Jsoup.connect(url).get();
			Elements list = doc.getElementsByClass("sub_book_list");
			for(Element e:list) {
				String title = e.getElementsByClass("book_tit").text();
				String link = "https://www.hanbit.co.kr"+e.attr("thumb");
				WebtoolController.downloadImage(link, title);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("newBook error: "+e.getMessage());
		}
		return "OK";
	}
	@GetMapping("/restSeat")
	public String restSeat() {
		String no = "";
		String url = "http://mpllc-seat.sen.go.kr/seatinfo/Seat_Info/1_count.asp";
		try {
			Document doc = Jsoup.connect(url).get();
			Element e = doc.getElementsByClass("wating_f").get(0);
			no = e.text();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("restSeat: "+e.getMessage());
		}
		return no;
	}
}
