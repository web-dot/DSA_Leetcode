package com.dsa.two_pointers;

public class TwoPointerProblems {

	
	/**
	 * P1: TWO POINTERS 557 : reverse words in string : 
	 * 
	 * */
	public static String reverseWords(String s) {
		String[] sarr = s.split(" ");
		for(int i=0; i<sarr.length; i++) {
			String word = sarr[i];
			for(int j=0; j<word.length(); j++) {
				char c = word.charAt(j);
				int p1 = 0;
				int p2 = word.length()-1;
				System.out.println(c);
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		
		String s = "Let's take LeetCode contest";
		reverseWords(s);

	}

}
