package com.dsa.strings;

import java.util.Arrays;

public class StringProblems {

	//Easy
	/**
	 * P 1 : STRING 1360 : number of days between two dates
	 * */
	public static int daysBetweenDates(String date1, String date2) {
		String[] d1 = date1.split("-");
		String[] d2 = date2.split("-");
		System.out.println(Arrays.toString(d1) + " : " + Arrays.toString(d2));
		
		int year1 = Integer.parseInt(d1[0]);
		int month1 = Integer.parseInt(d1[1]);
		int day1 = Integer.parseInt(d1[2]);
		int days1 = 365*year1 + 31*(month1-1);
		
		int year2 = Integer.parseInt(d2[0]);
		int month2 = Integer.parseInt(d2[1]);
		int day2 = Integer.parseInt(d2[2]);
		int days2 = 365*year2 + 31*(month2-1);
		
		System.out.println(days1 + " : " + days2);
		
		if(days1 > days2) {
			return days1 - days2;
		}
		else if(days1 < days2) {
			return days2 - days1;
		}
		else
			return 0;
	}
	
	
	public static void main(String[] args) {
		
		String d1 = "2020-01-15";
		String d2 = "2019-12-31";
		System.out.println(daysBetweenDates(d1, d2)); 
	}
}
