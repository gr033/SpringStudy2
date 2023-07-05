package com.example.demo.util;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SistUtil {
	@Scheduled(cron = "30 30 11 5 * *")
	public void pro() {
		System.out.println("급여명세서");
	}
}
