package com.dsa.projected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringProblems {
	
	/**
	 * P2: LC 5 : Longest Palindromic Substring
	 * 
	 * Given a string s, return the longest palindromic substring in s
	 * 
	 * 1. "babad" -> "bab"
	 * 2. "cbbd" -> bb
	 * .3 "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth" -> ranynar
	 * 
	 * */
	
	// approach 01 - the method takes lot of time for long strings
	public static String longestPalindrome1(String s) {
		if(s.isEmpty()) {
			return "";
		}
		if(s.length() == 1) {
			return s;
		}
		if(s.length() == 2) {
			if(s.split("")[0].equals(s.split("")[1])) {
				return s;
			}
			else
				return s.split("")[0];
		}
		char[] carr = s.toCharArray();
		StringBuilder builder = new StringBuilder();
		List<String> subsList = new ArrayList<>();
		List<String> palindromes = new ArrayList<>();
		String longestPalindrome = "";
		for(int i=0 ; i<carr.length; i++) {
			for(int j=i+1; j<carr.length; j++) {
				if(carr[i] == carr[j]) {
					String sub = s.substring(i, j+1);
					subsList.add(sub);
				}
				else {
					longestPalindrome = s.split("")[0];
				}
			}
		}
		for(String sub : subsList) {
			int left = 0;
			int right = sub.length()-1;
			boolean palindrome = true;
			while(right > left) {
				if(sub.charAt(left) != sub.charAt(right)) {
					palindrome = false;
				}
				left++;
				right--;
			}
			if(palindrome) {
				palindromes.add(sub);
			}
		}
		for(String palindrome : palindromes) {
			if(palindrome.length() > longestPalindrome.length()) {
				longestPalindrome = palindrome;
			}
		}
		return longestPalindrome;
	}
	
	
	// approach 02 -> assume each character as the center of the palindrome
	
	public static String longestPalindrome2(String s) {
		int start = 0;
		int end = 0;
		
		for(int i=0; i<s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			
			if(len > (end - start)) {
				start = i - (len-1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	public static int expandAroundCenter(String inputString, int left, int right) {
		while(left >= 0 && right < inputString.length() && (inputString.charAt(left) == inputString.charAt(right))) {
			left--;
			right++;
		}
		return right - left -1;
	}
	
	
	/**
	 * P3 : LC 557 : Reverse words in a string III
	 * 
	 * Given a string s, reverse the order of characters in each word within a 
	 * sentence while still preserving whitespace and initial word order
	 * 
	 * God Ding -> doG gniD
	 * 
	 * */
	public static String reverseWordsInString(String s) {
		if(s.isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		String[] sarr = s.split(" ");
		for(String str : sarr) {
			char[] carr = str.toCharArray();
			int left = 0;
			int right = carr.length-1;
			while(right > left) {
				char temp = carr[left];
				carr[left] = carr[right];
				carr[right] = temp;
				right--;
				left++;
			}
			sb.append(carr);
			sb.append(" ");
		}
		return sb.toString().trim();
	}
	
	
	/**
	 * P1 : LC 3 : Length of the longest substring without repeating chars
	 * */
	public static String longestSubstring(String s) {
		if(s.isEmpty()) {
			return "";
		}
		int start = 0;
		int end = 0;
		for(int i=0; i<s.length(); i++) {
			int len = findLength(s, i, i+1);
			
			if(len > (end - start)) {
				start = i;
				end = i + len;
			}
		}
		return s.substring(start, end+1);
		
	}
	
	public static int findLength(String inputString, int left, int right) {
		while(right < inputString.length() && inputString.charAt(left) != inputString.charAt(right)) {
			right++;
		}
		return right - left - 1;
	}
	
	
	public static void main(String[] args) {

		// problem 1
		String s = "au";
		System.out.println(longestSubstring(s));
		
		// problem 2
		String str = "abcabac";
//		System.out.println(longestPalindrome2(str));
//		System.out.println(longestPalindrome1("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
}
