package com.sist.util;

import com.example.demo.vo.EmpVO;

public class MyUtil {
	
	public static String getHtml(EmpVO e) {
		String str = "";
		str += "<h2>급여명세서</h2><br>" 
			+ "<table border=\"1\" width=\"50%\">" 
			+ "<tr>" 
			+ "<th>사원번호</th>"
			+ "<th>사원명</th>" 
			+ "<th>부서번호</th>" 
			+ "<th>입사일</th>" 
			+ "<th>급여</th>" 
			+ "<th>수당</th>" 
			+ "<th>실수령액</th>" 
			+ "</tr>" 
			+ "<tr>" 
			+ "<td>" + e.getEno() + "</td>" 
			+ "<td>" + e.getEname() + "</td>" 
			+ "<td>" + e.getDno() + "</td>" 
			+ "<td>" + e.getHiredate() + "</td>" 
			+ "<td>" + e.getSalary() + "</td>"
			+ "<td>" + e.getComm() + "</td>" 
			+ "<td>" + (e.getSalary() + e.getComm()) + "</td>" 
			+ "</tr>" 
			+ "</table>";
		return str;
	}
	
	public static String getRenameNotMultiple(String oldFname) {
		String fname = "";
		long n = System.currentTimeMillis();

		String fname1 = oldFname.substring(0, oldFname.lastIndexOf("."));
		String fname2 = oldFname.substring(oldFname.lastIndexOf("."));
		
		System.out.println(fname1);
		System.out.println(fname2);
		fname = fname1 + n + fname2;
		return fname;
	}
}	
