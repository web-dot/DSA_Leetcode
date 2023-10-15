package com.dsa.projected;

public class ProblemsRecode {
	
	// longest palindrome in a string
	public static String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		
		for(int i=0; i<s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			
			if(len > (end - start)) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	public static int expandAroundCenter(String inputString, int left, int right) {
		while(left >= 0 && right < inputString.length() 
				&& inputString.charAt(left) == inputString.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
	
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abcabac"));
	}
}
