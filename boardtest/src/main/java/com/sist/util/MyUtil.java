package com.sist.util;

public class MyUtil {
	
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
