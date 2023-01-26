package com.dsa.array;

import java.util.Arrays;

public class ArrayProblems {
	
	
	
	/*
	 * EASY -->
	 * 
	 * PROBLEM 1:
	 * 
	 * given an integer arr nums of length n, create a array ans of length
	 * 2n, where ans[i] == nums[i] and ans[i + n] == nums[i], for 0<=i<=n.
	 * ans is the concatenation of two nums arrays;
	 * 
	 * ACCEPTED
	 * runtime - 1ms - beats 97%
	 * memory - 42.9mb - beats - 65%
	 * */
	public static int[] getConcatenation(int[] nums) {
		int len = 2*nums.length;
		int[] ans = new int[len];
		int countlen = nums.length;
		for(int i=0; i<countlen; i++) {
			ans[i] = nums[i];
			if(i==countlen-1) {
				int k = 0;
				for(i=countlen; i<len; i++) {
					ans[i] = nums[k];
					k++;
				}
			}
		}
		return ans;
	}
	
	
	/*
	 * PROBLEM 2:
	 * 
	 * there is a programming language with only one variable X and four 
	 * operations --X, X--, ++X, X++,
	 * given a array of string operations, return the final value of X  
	 * 
	 * */
	public static int finalValueAfterOperations(String[] operations) {
		int var = 0;
		for(int i=0; i<operations.length; i++) {
			switch(operations[i])
			{
			case "++X":
				var += 1;
				break;
			case "X++":
				var +=1;
				break;
			case "--X":
				var -=1;
				break;
			case "X--":
				var -=1;
				break;
			}
		}
		return var;
	}
	
	
	/*
	 * PROBLEM 3:
	 * 
	 * given the array nums consisting of 2n elements in the form [x1,x2,..,xn,y1,y2,..,yn].
	 * return the array of the form [x1,y1,x2,y2,..,xn,yn]
	 * 
	 * -> can the array be empty ->> supposedly no
	 * -> can the n be out out of bounds ->> supposedly no
	 * -> can n be the last index ->> may be
	 * -> do i have to do this in place ->> supposedly you can, but not mandatory
	 * example:
	 * 
	 * [2,5,1,3,4,7],3 -> [2,3,5,4,1,7]
	 * [1,2,3,4,4,3,2,1],4 -> [1,4,2,3,3,2,4,1]
	 * 
	 * steps:
	 * so, to approach the problem in a simple way at first:
	 * 
	 *  1. i will create a new array of same length
	 *  2. iterate nums till n and fill up the new array every consecutive element with nums elements
	 *  3. i will iterate nums from n, and fill up the new array from index 1 and every second index with nums elements.
	 *  
	 * 
	 * */
	public static int[] shuffle(int[] nums, int n) {
		int[] base = new int[nums.length];
		int j = 0;
		for(int i=0; i<nums.length/2; i++) {
			base[j] = nums[i];
			j+=2;
		}
		int k = 1;
		for(int i=n; i<nums.length; i++) {
				base[k] = nums[i];
				k+=2;
		}
		return base;
	}
	
	public static void main(String[] args) {
		
		int[] arr2 = {1,2,3,4,4,3,2,1}; // works
		int[] arr = {2,5,1,3,4,7}; // works
 		System.out.println(Arrays.toString(shuffle(arr2, 4)));
		
		/*
		String[] operations = {"++X","++X","X--"};
		System.err.println(finalValueAfterOperations(operations));
		*
		/*
		int[] nums = {1, 2, 1};
		int[] ans = getConcatenation(nums);
		System.err.println(Arrays.toString(ans));
		*/
	}
}
