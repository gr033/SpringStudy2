package com.example.demo.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
}
