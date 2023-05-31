package com.dsa.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AngelLeonardProblems {

	
	// counting duplicate characters
	public static Map<Character, Integer> countDuplicatesChars(String str){
		Map<Character, Integer> result = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			result.compute(c,  (k, v) -> (v == null) ? 1 : ++v);
		}
		return result;
	}
	
	// using stream
	// Collectors.counting -> downstream collector
	public static Map<Character, Long> countDuplicateCharsUsingStream(String str){
		Map<Character, Long> result = str.chars()
		.mapToObj(c ->(char)c)
		.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return result;
		
		
		/**
		 * the mapToObj method calls the apply method of the IntFunction<R> functional interface,
		 *  providing the current int value from the stream as the argument to the lambda expression
		 * */
		/*
		str.chars()
		.mapToObj(new IntFunction<Character>() {
			@Override
			public Character apply(int value) {
				return (char)value;
			}
		});
		*/
		
	}
	
	public static void main(String[] args) {
		System.out.println(countDuplicateCharsUsingStream("programming"));
		
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
		
		// string.chars()
		String s = "Hello";
		IntStream charStream = s.chars();
		charStream.forEach(System.out::println);
		List<Character> charList = charStream.mapToObj(c -> (char)c).collect(Collectors.toList()); // IllegalStateException
		System.out.println(charList);
	}
	
}
