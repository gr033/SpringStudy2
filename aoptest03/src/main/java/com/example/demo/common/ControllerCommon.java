package com.example.demo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerCommon {
	
//	@Pointcut("execution (public * com.example.demo.controller..*(..))")
	public void before_controller() {}
	
//	@Around("before_controller()")
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		try {
			long start = System.currentTimeMillis();
			obj = joinPoint.proceed();
			long end = System.currentTimeMillis();
			long delay = end-start;
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+"/"+delay);
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println("ControllerCommon.Around error: "+e.getMessage());
		}
		
		return obj;
		
	}
	
	/*
	 * @Before("before_controller()") public void pro() {
	 * System.out.println("Controller 동작 전"); }
	 */
	
}
