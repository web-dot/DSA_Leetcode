package com.dsa.projected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CodingStringProblems {
	
	
	// counting duplicate characters
	// return index of first unique character
	
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
	
	public static int firstUniqueChar(String s) {
		Map<Integer, Integer> countMap = new LinkedHashMap<>();
		for(int i=0; i<s.length(); i++) {
			countMap.compute(i, (k, v) -> v == null ? 1 : v + 1);
		}
		System.out.println(countMap);
		int index = -1;
		for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if(entry.getValue() == 1) {
				index = entry.getKey();
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		
		System.out.println(firstUniqueChar("cbca"));
//		System.out.println(countDuplicates("maddm"));
	}
}
