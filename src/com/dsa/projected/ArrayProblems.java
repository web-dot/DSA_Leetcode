package com.dsa.projected;

import java.util.Arrays;

public class ArrayProblems {
	
	
	//1. given an integer array nums, move all 0's to the end of it , while
	// maintaining the order of the non-zero elements

	// must do this in place without making copy of array
	public static void moveZerosLeft(int[] nums) {
		int read = 0;
		int write = 0;
		while(read < nums.length) {
			if(nums[read] != 0) {
				nums[write] = nums[read];
				write++;
			}
			read++;
		}
		for(int i=write; i<nums.length; i++) {
			nums[i] = 0;
		}
	}
	
	// 2. move zeros to the right
	public static void moveZerosRight(int[] nums) {
		int read = nums.length-1;
		int write = nums.length-1;
		while(read >= 0) {
			if(nums[read] != 0) {
				nums[write] = nums[read];
				write--;
			}
			read--;
		}
		for(int i = write; i >= 0; i--) {
			nums[i] = 0;
		}
	}
	
	// 3. Given an integer array, return largest sum of non-adjacent numbers
	public static int nonAdjLargestSum(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i=2; i<nums.length; i++) {
			int option1 = nums[i] + dp[i-2];
			int option2 = dp[i-1];
			dp[i] = Math.max(option1, option2);
		}
		return dp[dp.length-1];
	}
	
	
	// p4 given an integer array return an array nums that is a concat of nums with itself
	public static int[] getConcatenation(int[] nums) {
		int[] ans = new int[2*nums.length];
		int n = nums.length;
		for(int i=0; i<nums.length; i++) {
			ans[i] = nums[i];
			ans[i+n] = nums[i];
		}
		return ans;
	}
	
	
	// given an array nums consisting of 2n elements in the form [x1,x2...,]
	// return the array in the form [x1,y1,x2,y2]
	// input = [2,5,1,3,4,7], n=3
	// output = [2,3,5,4,1,7]
	public static int[] shuffle(int[] nums, int n) {
		int[] result = new int[2*n];
		int index = 0;
		for(int i=0; i<n; i++) {
			result[index++] = nums[i];
			result[index++] = nums[i + n];
		}
		return result;
	}
	
	// given unsorted integer array, return the smallest positive integer
	public static int smallestPositive(int[] nums) {
		Arrays.sort(nums);
		int x = nums[0];
		for(int i=0; i<nums.length; i++) {
			if(nums[i] < x) {
				x = nums[i];
			}
		}
		return x;
	}
	
	public static void main(String[] args) {
		
		System.out.println(smallestPositive(new int[] {2,1,4,3}));
		
		
//		int[] nums = new int[] {1,2,1};
//		System.out.println(Arrays.toString(getConcatenation(nums)));
		
		// p3
//		int[] nums = {0};
//		System.out.println(nonAdjLargestSum(nums));
		
		// p1 and p2
//		int[] arr = new int[]  {12,0,13,0,2,0,3,0};
//		moveZerosRight(arr);
//		System.out.println(Arrays.toString(arr));
		
	}
}
