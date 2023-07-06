package com.example.demo.common;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Aspect
public class WriteFileLog {
	
	@Pointcut("execution (public * com.example.demo.controller..*(..))")
	public void sistlog() {}
	
	@Around("sistlog()")
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		String methodName = joinPoint.getSignature().toShortString();
		Object[] args = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest) args[0];
		String ip = request.getRemoteAddr();
		String uri = request.getRequestURI();
		try {
			long start = System.currentTimeMillis();
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			long delay = end-start;
			String data = uri+"/"+methodName+"/"+ip+"/"+delay+"\n";

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Calendar c = Calendar.getInstance();
			String str = sdf.format(c.getTime());
			String fname = "C:/sist_log/"+str+".txt";
			FileWriter fw = new FileWriter(fname, true);
			fw.write(data);
			fw.close();
			
			System.out.println(data);
		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println("예외발생: "+e.getMessage());
		}
		return obj;
	}
}
