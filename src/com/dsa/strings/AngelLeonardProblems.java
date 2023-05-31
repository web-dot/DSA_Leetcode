package com.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class AngelLeonardProblems {

	
	// counting duplicate characters
	public static Map<Character, Integer> countDuplicates(String str){
		Map<Character, Integer> result = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			result.compute(c,  (k, v) -> (v == null) ? 1 : ++v);
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(countDuplicates("programming"));
		
		Map<Character, Integer> map = new HashMap<>();
		char key = 'a';
		int value = 1;
		
		// using map.compute()
		map.compute(key, (k, v) -> (v == null) ? value : v + value);
		
		// using map.contains()
		if(map.containsKey(key)) {
			map.put(key, map.get(key) + value);
		}
		else {
			map.put(key, 1);
		}
		
	}
	
}
