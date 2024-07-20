package com.dsa.interview_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewProblems {
	
	/**
	 * Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
	 * */
	public static boolean threeConsecutiveOdds(int[] arr) {
		boolean oddConsExist = false;
		if(arr.length < 3) {
			return false;
		}
		for(int i=0; i<arr.length-2; i++) {
			if(arr[i]%2==1 && arr[i+1]%2==1 && arr[i+2]%2==1) {
				oddConsExist = true;
			}
		}
		return oddConsExist;
	}
	
	
	/**
	 * Given an array of integers nums and an integer target, 
	 * return indices of the two numbers such that they add up 
	 * to target.
	 * */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> compMap = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if(compMap.containsKey(complement)) {
				int[] arr = {compMap.get(complement), i};
				return arr;
			}
			compMap.put(nums[i], i);
		}
		return new int[0];
	}
	
	// reverse integer
	public static int reverse(int x) {
		List<Integer> list = new ArrayList<>();
		int rem = x;
		while(rem > 0) {
			rem = x % 10;
			if(rem > 0) {
				list.add(rem);
			}
			x = x / 10;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i));
		}
		return Integer.parseInt(sb.toString());
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(-124));
		int[] input = {3,2,3};
//		System.out.println(Arrays.toString(twoSum(input, 6)));
		int[] arr = {2,3,7,8};
//		System.out.println(threeConsecutiveOdds(arr));
	}
}
