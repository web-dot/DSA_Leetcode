package com.dsa.projected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringProblems {
	
	/**
	 * P1: LC 5 : Longest Palindromic Substring
	 * 
	 * Given a string s, return the longest palindromic substring in s
	 * 
	 * 1. "babad" -> "bab"
	 * 2. "cbbd" -> bb
	 * 
	 * */
	public static String longestPalindrome(String s) {
		
		// bcfdfchmdfd
		char[] carr = s.toCharArray();
		StringBuilder builder = new StringBuilder();
		List<String> subsList = new ArrayList<>();
		for(int i=0 ; i<carr.length; i++) {
			for(int j=i+1; j<carr.length; j++) {
				System.out.println(carr[i] + " : "  + carr[j]);
				if(carr[i] == carr[j]) {
					String sub = s.substring(i, j);
					System.out.println("may be = " + carr[i]);
				}
			}
			System.out.println();
		}
		System.out.println(subsList.toString());
		return null;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("bcfdfchmdfd"));
	}
}
