package com.dsa.projected;

import java.util.Arrays;

public class ArrayProblems {
	
	
	//1. given an integer array nums, move all 0's to the end of it , while
	// maintaining the order of the non-zero elements
	
	// must do this in place without making copy of array
	public static void moveZeros(int[] nums) {
		// [0,1,3,0] -> [1,3,0,0,]
		int k =0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != 0) {
				int temp = nums[i];
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = new int[]  {0,1,0,3,12};
		int[] rarr = moveZeros(arr);
		System.out.println(Arrays.toString(rarr));
	}
}
