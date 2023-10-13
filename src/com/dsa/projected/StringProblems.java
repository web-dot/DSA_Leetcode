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
	 * .3 "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth" -> ranynar
	 * 
	 * */
	public static String longestPalindrome(String s) {
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
	
	
	/**
	 * P2 : LC 557 : Reverse words in a string III
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
	
	
	
	public static void main(String[] args) {
		System.out.println(reverseWordsInString("hehhhhhhe"));
//		System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
}
