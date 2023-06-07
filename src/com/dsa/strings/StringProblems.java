package com.dsa.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class StringProblems {

	// Easy
	/**
	 * P 1 : STRING 1360 : number of days between two dates
	 */
	public static int daysBetweenDates(String date1, String date2) {
		String[] d1 = date1.split("-");
		String[] d2 = date2.split("-");
		System.out.println(Arrays.toString(d1) + " : " + Arrays.toString(d2));

		int year1 = Integer.parseInt(d1[0]);
		int month1 = Integer.parseInt(d1[1]);
		int day1 = Integer.parseInt(d1[2]);
		int days1 = 365 * year1 + 31 * (month1 - 1);

		int year2 = Integer.parseInt(d2[0]);
		int month2 = Integer.parseInt(d2[1]);
		int day2 = Integer.parseInt(d2[2]);
		int days2 = 365 * year2 + 31 * (month2 - 1);

		System.out.println(days1 + " : " + days2);

		if (days1 > days2) {
			return days1 - days2;
		} else if (days1 < days2) {
			return days2 - days1;
		} else
			return 0;
	}

	/**
	 * P2 : string 1108 : Defang a IPv4 address
	 * 
	 */
	public static String defangIPaddr(String address) {
		String newIp = address.replace(".", "[.]");
		return newIp;
	}

	/**
	 * P3 : LEET 1119 : REMOVE VOWELS FROM A STRING
	 */
	public static String removeVowels(String str) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vowels.length; i++) {
			char c = str.charAt(i);
			for (int j = 0; j < str.length(); j++) {
				System.out.print(vowels[j] + " ");

			}
			System.out.println();
		}
		return sb.toString();
	}

	/*
	 * optimized - using HashSet in place of an array to store the vowels for
	 * constant time lookup - using StringBuilder to store the newly created array
	 */
	public static String removeVowelsOptimized(String str) {
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!vowels.contains(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * P4: EXPONENT CODING INTERVIEW : given two strings, the `start` and the `goal`
	 * string, return true if you can swap any two letters in the `start` string so
	 * that the result is equal to the `goal` string.
	 */
	public static boolean testStrings(String start, String goal) {
		if (start.length() != goal.length()) {
			return false;
		}
		char[] startArr = start.toCharArray();
		char[] goalArr = goal.toCharArray();
		char p1 = startArr[0];
		char p2 = goalArr[0];
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < startArr.length; i++) {
			p1 = startArr[i];
			for (int j = i; j < i + 1; j++) {
				p2 = goalArr[j];
				if (p1 != p2) {
					int index = i;
					set.add(p1);
					set.add(p2);
				}
			}
		}
		return (set.size() == 2);
	}

	/** CODING BAT : STRING-2 */

	/**
	 * P5: Given s string, return the result string where for every char in the
	 * original string there are two chars
	 */
	public static String doubleChar(String str) {
		char bro = ' ';
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			bro = c;
			sb.append(c).append(bro);
		}
		return sb.toString();
	}

	/**
	 * p6: count `hi`. Return the number of times that "hi" appears
	 */
	public static int countHi(String str) {
		int count = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			char c = str.charAt(i);
			char d = str.charAt(i + 1);
			if (c == 'h' && d == 'i') {
				count++;
			}
		}
		return count;
	}

	/**
	 * p7 : Return true if the string "cat" and "dog" appears the same number of
	 * times in given string
	 */
	public static boolean catDog(String str) {
		int catCount = 0;
		int dogCount = 0;
		for (int i = 0; i < str.length() - 2; i++) {
			char c = str.charAt(i);
			if (c == 'c' || c == 'd') {
				String sub1 = str.substring(i, i + 3);
				if (sub1.equals("cat")) {
					catCount++;
				}
				if (sub1.equals("dog")) {
					dogCount++;
				}
			}
		}
		return catCount == dogCount;
	}

	/**
	 * p8 : return the numebr of times that the string "code" anywhere in the given
	 * string. except we'll accept any letter for the 'd', so "cope" and "cooe"
	 * count
	 */
	public static int countCode(String str) {
		String match = "code";
		String preSub = "co";
		int count = 0;
		for (int i = 0; i < str.length() - 3; i++) {
			char c = str.charAt(i);
			String sub1 = "";
			String sub2 = "";
			if (c == 'c') {
				sub1 = str.substring(i, i + 2);
				sub2 = str.substring(i + 3, i + 4);
			}
			if (sub1.equals(preSub) && sub2.equals("e")) {
				count++;
			}
		}
		return count;
	}

	/**
	 * p9 : given two strings, return true if either of the strings appear at the
	 * very end of the other string. ignore case
	 */
	public static boolean endOther(String a, String b) {
		int l1 = a.length();
		String reversed = new StringBuilder(b).reverse().toString();
		String backToFront = reversed.substring(0, l1);
		return false;
	}

	/**
	 * P10 CGPT : given two strings write a function to check if they are anagrams of
	 * each other
	 */

	// time complexity O(nlogn)
	public static boolean anagrams(String s1, String s2) {
		char[] sarr1 = s1.toCharArray();
		char[] sarr2 = s2.toCharArray();
		Arrays.sort(sarr1);
		Arrays.sort(sarr2);
		String str1 = new String(sarr1);
		String str2 = new String(sarr2);

		return str1.equals(str2);
	}

	public static boolean anagrams2(String s1, String s2) {
		Map<Character, Integer> cmap1 = new HashMap<>();
		Map<Character, Integer> cmap2 = new HashMap<>();

		if (s1.length() != s2.length()) {
			return false;
		}

		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			if (cmap1.containsKey(c1)) {
				cmap1.put(c1, cmap1.get(c1) + 1);
			} else {
				cmap1.put(c1, 1);
			}
		}
		
		for (int i = 0; i < s2.length(); i++) {
			char c2 = s2.charAt(i);
			if (cmap2.containsKey(c2)) {
				cmap2.put(c2, cmap2.get(c2) + 1);
			} else {
				cmap2.put(c2, 1);
			}
		}

		//time complexity O(n), 
		for(Map.Entry<Character, Integer> entry : cmap1.entrySet()) {
			char c = entry.getKey();
			int count1 = entry.getValue();
			int count2 = cmap2.getOrDefault(c, 0);
			if(count1 != count2) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * P11 | LC 14 : write a function to find the longest common prefix string amongst an 
	 * array of strings
	 * */
	public static String longestPrefix(String[] arr) {
		//flower","flow","flight
		if(arr == null || arr.length == 0) {
			return "";
		}
		String prefix = arr[0];
		for(int i=1; i<arr.length; i++) {
			while(arr[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty()) {
					return "";
				}
			}
		}
		return prefix;
	}
	
	/**
	 * find longest prefix : 
	 * */
	public static String findLongestPrefix(String[] arr) {
		if(arr == null || arr.length == 0) {
			return "";
		}
		String prefix = arr[0];
		for(int i=0; i<arr.length; i++) {
			while(arr[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length()-1);
				if(prefix.isEmpty()) {
					return "";
				}
			}
		}
		return prefix;
	}
	
	
	/**
	 * given a string find the length of the longest substring without repeating 
	 * characters
	 * */
	
	/**
	 *	okay, to solve this, the approach that i am thinking is, that:
	 *
	 *	1. split the string into a string array.
	 *	2. create a variable `start` and set to 0 and `sub` and set to a empty string 
	 *	3. iterate the array and check if `sub` contains the element
	 * 	4. if it does not, i will append to it.
	 * 	5. else, means the i have found a element that is a duplicate, in that case,
	 * 		a. add `sub` to a List of strings called `subList`
	 * 		b. set `start` to the duplicate element index
	 * 		c. reset the variable `sub`(sub = s.substring(start, i+1))
	 * 	6. outside the iteration, i will get hold of the longest string in `subList`,
	 * 		and return the length.
	 * 
	 * Complexity = O(n) :|
	 * 
	 * */
	public static int findLongestSubUsingMy(String s) {
		List<String> uniqueSubList = new ArrayList<>();
		String[] arr = s.split("");
		int start = 0;
		String uniqueSub = "";
		if(s.isEmpty()) {
			return 0;
		}
		else {
		for(int i=0; i<arr.length; i++) {
			String currentChar = arr[i];
			if(!uniqueSub.contains(arr[i])) {
				uniqueSub += currentChar; 
			}
			else {
				uniqueSubList.add(uniqueSub);
				start += uniqueSub.indexOf(currentChar) + 1;
				uniqueSub = s.substring(start, i+1);
			}
		}
		}
		uniqueSubList.add(uniqueSub);
		String longestSub = "";
		for(String substring : uniqueSubList) {
			if(substring.length() > longestSub.length()) {
				longestSub = substring;
			}
		}
		return longestSub.length();
	}
	
	
	/**
	 * Brute force approach -
	 *  
	 * brute force approach for finding the longest substring without reapeating character
	 * would involve checking all possible substrings in the input string and determining 
	 * if each substring has unique characters.
	 * 
	 * 	-> iterate through all possible starting indices of the substring
	 * 	-> for each starting index, iterate through all possible ending indices of the substring
	 * 	-> check if the substring from starting index to the ending index(inclusive) has unique character
	 * 	-> if the substring has unique character and its length is greater than `maxLength`, update `maxLenght` and start
	 * 	-> repeat 2-5 untill all the substrings are checked 
	 * 	-> extract longest substring from input string using `start` and `maxLength`
	 * 	
	 * complexity - O(n^3) :(
	 * 
	 * */
	public static int findLongestSubByBrute(String s) {
		int n = s.length();
		int maxLength = 0;
		int start = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(hasUniqueCharacters(s, i, j)) {
					int length = j - i + 1;
					if(length > maxLength) {
						maxLength = length;
						start = i;
					}
				}
			}
		}
		return s.substring(start, start + maxLength).length();
	}
	
	/**
	 * Optimizing the brute force solution:
	 * 
	 * To optimize the brute force solution a `sliding window` approach is used
	 * with two pointers, `start` and `end` to represent the current substring. 		
	 * 
	 * */
	public static int findLongestSubBySlidingWindow(String s) {
		int n = s.length();
		int maxLength = 0;
		int start = 0;
		
		int[] charCount = new int[128]; // Assuming ASCII character
		
		for(int end=0; end<n; end++) {
			char currentChar = s.charAt(end);
			charCount[currentChar]++;
			while(charCount[currentChar] > 1) {
				char startChar = s.charAt(start);
				charCount[startChar]--;
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
	
	
	
	
	public static boolean hasUniqueCharacters(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for(int i=start; i<=end; i++) {
			char c = s.charAt(i);
			if(set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}
	
	
	
	
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
      int left = 0;
      int right = 0;
      int maxLength = 0;
      int start = 0;
      // abcabcbb
      while(right<s.length()){
         if(!set.contains(s.charAt(right))){
            set.add(s.charAt(right));
            if(right-left+1 > maxLength){
               maxLength = right - left + 1;
               start = left;
            }
            right++;   
         }
         else{
            set.remove(s.charAt(left));
            left++;
         }
      }
      return s.substring(start, start + maxLength).length();
	}
	
	
	/**
	 * REPLACE VOWELS IN A STRING
	 * */
	private static final String VOWEL_STRING = "aeiou";
	public static String replaceVowels(String str) {
		if(str.isEmpty()) {
			return "";
		}
		
		char[] carr = str.toCharArray();
		for(int i=0; i<carr.length; i++) {
			char ch = carr[i];
			if(VOWEL_STRING.contains(String.valueOf(ch))) {
				str = str.replace(String.valueOf(ch), ""); 
			}
		}
		return str;
	}
	

	public static void main(String[] args) {

		String s2 = "abcabcbb";
		System.out.println(replaceVowels("Code"));

		/**
		 * Exponent start-goal test cases String start1 = "lhicl"; String goal1 =
		 * "chill";
		 * 
		 * String start2 = "doce"; String goal2 = "code";
		 * 
		 * String start3 = "star"; String goal3 = "tar";
		 * 
		 * 
		 * String start4 = "xoye"; String goal4 = "code";
		 * 
		 * System.out.println(testStrings(start1, goal1));
		 * System.out.println(testStrings(start2, goal2));
		 * System.out.println(testStrings(start3, goal3));
		 * System.out.println(testStrings(start4, goal4));
		 * 
		 */
	}
}
