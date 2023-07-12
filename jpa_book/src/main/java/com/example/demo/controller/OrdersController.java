package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BookService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.OrdersService;
import com.example.demo.service.View_ListOrdersService;
import com.example.demo.vo.OrdersVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class OrdersController {
	@Autowired	
	private OrdersService os;
	
	@Autowired
	private BookService bs;
	
	@Autowired
	private CustomerService cs;
	
	@Autowired
	private View_ListOrdersService vs;
	
	
	@GetMapping("/orders/insert")
	public void insert(Model model) {
		model.addAttribute("no", os.getNextNo());
		model.addAttribute("c_list", cs.findAll());
		model.addAttribute("b_list", bs.findAll(null, null));
	}
	
	@PostMapping("/orders/insert")
	public ModelAndView insert(OrdersVO o) {
		ModelAndView mav = 
			new ModelAndView("redirect:/orders/list");
		os.insert(o);
		return mav;
	}
	
	@GetMapping("/orders/list")
	public void list(Model model) {
		model.addAttribute("list", os.findAll());
	}
	
	@RequestMapping("/orders/list2")
	public void list2(Model model, String cname, 
			String keyword, String sname, 
			HttpSession session, HttpServletRequest request) {	
		
		if(session.getAttribute("keyword") != null) {
			cname= (String)session.getAttribute("cname");
			keyword= (String)session.getAttribute("keyword");
		}		
		if(request.getParameter("keyword") != null) {
			cname = request.getParameter("cname");
			keyword = request.getParameter("keyword");
		}		
		model.addAttribute("list", vs.findAll(cname, keyword, sname));
		session.setAttribute("cname", cname);
		session.setAttribute("keyword", keyword);
	}
}
