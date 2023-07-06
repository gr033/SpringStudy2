package com.example.demo.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DaoCommon {
	
	@Pointcut("execution(public * com.example.demo.dao..*(..))")
	private void pro() {}
	
	@Before("pro()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Calendar c = Calendar.getInstance();
		String now = sdt.format(c.getTime());
		System.out.println("메소드 요청 시간: "+now);
		System.out.println("메소드명: "+methodName);
	}
	
	//타겟 메소드가 정상완료하거나 비정상완료하거나 반드시 동작하는 어드바이스를 만들고 결과를 확인
//	@After("pro()")
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+": 타겟 메소드 완료");
	}
	
//	@AfterThrowing("pro()")
	public void afterThrow(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+": 타겟 메소드 비정상 완료");
	}
	
//	@AfterReturning("pro()")
	public void afterReturn(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+": 타겟 메소드 정상완료");
	}
	
//	@Before("pro()")
	public void before(JoinPoint joinPoint) {
		String methodName =
				//어느 패키지에 있는지 확인
				joinPoint.getSignature().getDeclaringTypeName();
//				그냥 이름만 확인
//				joinPoint.getSignature().getName();
		
		String name1 = joinPoint.getSignature().toLongString();
		String name2 = joinPoint.getSignature().toShortString();
				
		System.out.println(methodName+ ": 타겟메소드 동작 전");
		
		//public java.util.List com.example.demo.dao.DeptDAO.findAll(): toLongString
		System.out.println(name1+ ": toLongString");
		//DeptDAO.findAll(): toShortString	
		System.out.println(name2+ ": toShortString");
	}
	
//	@Around("pro()")
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
			
		}
		return obj;
	}
}
