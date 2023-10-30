package com.dsa.projected;

import java.util.HashMap;
import java.util.Map;

public class CodingStringProblems {
	
	
	// counting duplicate characters
	// find first non repeating character
	
	public static int countDuplicates(String s) {
		Map<Character, Integer> countsMap = new HashMap<>();
		int count = 0;
		for(Character c : s.toCharArray()) {
			countsMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}
		for(Map.Entry<Character, Integer> entry : countsMap.entrySet()) {
			if(entry.getValue() > 1) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countDuplicates("maddm"));
	}
}
