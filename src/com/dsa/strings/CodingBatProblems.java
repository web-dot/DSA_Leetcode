package com.dsa.strings;

import java.util.Arrays;

public class CodingBatProblems {
	
	/**
	 * find words ending with `y` and `z`
	 * 
	 * 
	 * 1. can the string be empty
	 * 2. can the string have characters other than alphabets 
	 * 3. is this case sensitive
	 * 
	 * */
	public static int countYZ(String str) {
		String[] arr = str.split(" ");
		int count = 0;
		boolean found = false;
		if(arr.length == 0) {
			return 0;
		}
		if(arr.length == 1) {
			String s = arr[0];
			for(int i=s.length(); i>0; i--) {
				char c = s.charAt(i-1);
				if(Character.isLetter(c) && !found) {						
						if(Character.toLowerCase(c) == 'y' || Character.toLowerCase(c) == 'z') {
							count++;
							found = true;
						}
				}
			}
		}
		else {
			for(int i=0; i<arr.length; i++) {
				String s = arr[i];
				found = false;
				for(int j=s.length(); j>0; j--) {
					char c = s.charAt(j-1);					
					if(Character.isLetter(c) && !found) {
						if(Character.toLowerCase(c) == 'y' || Character.toLowerCase(c) == 'z') {
							count++;
							found = true;
						}
					}
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		System.out.println(countYZ("day fez"));
	}
}
