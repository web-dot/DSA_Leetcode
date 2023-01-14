package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMath {
	
	/*
	 * Given an integer array A of size N.
	 * You have to pick exactly B elements 
	 * from either left or right end of the 
	 * array A to get the maximum sum.
	 * Find and return this maximum possible sum.
	 * */
	public static int maxSum1(List<Integer> A, int B) {
		
		for(int i = 0; i < A.size(); i++) {
			System.out.println(A.get(i));
		}
		
		return 0;
	}

	
	public static void main(String[] args) {
		
		List<Integer> A = new ArrayList<>(Arrays.asList(5, -2, 3, 1, 2));
		int B = 3;
		int maxsum = maxSum1(A, B);
		
	}
}
