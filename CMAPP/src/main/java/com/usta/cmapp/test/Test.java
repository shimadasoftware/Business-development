package com.usta.cmapp.test;

import java.math.BigDecimal;

public class Test {
	
	public static void main(String[] args) {
		BigDecimal number = new BigDecimal(-0.7);
		
		if (number.compareTo(BigDecimal.ZERO) < 0 || number.compareTo(BigDecimal.ZERO) > 0) {
			System.out.println("It is less");
		}
		
//		Date name = new Date();
//		
//		SimpleDateFormat f = new SimpleDateFormat("ddMMMMyyyy");
//		
//		String date = f.format(name);
//		String day = dat.substring(0, 2);
//		String month = dat.substring(3, dat.length()-5);
//		String year = dat.substring(dat.length()-4, dat.length());
//		
//		System.out.println(date);
//		System.out.println(day);
//		System.out.println(month);
//		System.out.println(year);
	}
}
