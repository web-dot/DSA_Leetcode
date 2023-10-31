package com.dsa.projected;

import java.util.Arrays;

public class ArrayProblems {
	
	
	//1. given an integer array nums, move all 0's to the end of it , while
	// maintaining the order of the non-zero elements
	
	// must do this in place without making copy of array
	public static void moveZeros(int[] nums) {
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
	
	
	
	public static void main(String[] args) {
		int[] arr = new int[]  {0,1,3,0};
		moveZeros(arr);
		System.out.println(Arrays.toString(arr));
	}
}
