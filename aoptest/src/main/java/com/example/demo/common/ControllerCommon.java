package com.example.demo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class ControllerCommon {
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	private void pro() {}
	
	@Around("pro()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		try {
			long start = System.currentTimeMillis();
			System.out.println("타겟 메소드 동작하기 전");
			
			//타겟 메소드를 호출
			obj = joinPoint.proceed();
			
			long end = System.currentTimeMillis();
			System.out.println("타겟 메소드 동작");
			System.out.println("걸린 시간: "+(end-start));
			
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println("around error: "+e.getMessage());
		}
		return obj;
	}
}
