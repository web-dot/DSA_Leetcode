package com.dsa.projected.common_strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. two pointers
 * 2. sliding window
 * 3. prefix sum
 * 4. hashing
 * 5. binary search
 * 6. greedy algorithm
 * 7. dynamic programming
 * 8. sorting
 * 9. binary representation
 * 10. kadens algorithm
 * 
 * */

public class StringProblems {

	// kaden's algorithm
	// max sum contiguous subarray
	public static int maxSumSubArray(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}
		int currentSum = nums[0];
		int maxSum = nums[0];
		for(int i=1; i<nums.length; i++) {
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}
	
	// brian kernighan's algorithm
	// given a non-negetive integer, count the number of set bits
	public static int countSetBits(int n) {
		//  8 4 2 1
		//  1 0 1 0
		int count = 0;
		while(n != 0) {
			n = n & (n-1);
			count++;
		}
		return count;
	}
	
	// getting array of the set bits
	public static int[] getSetBits(int n) {
		int[] result = new int[n+1];
		for(int i=0; i<=n; i++) {
			int num = i;
			int count = 0;
			while(num != 0) {
				num = num & (num-1);
				count++;
			}
			result[i] = count;
		}
		return result;
	}
	
	// sorting
	// given an array of strings strs, group the anagrams together.
	public static List<List<String>> groupAnagrams(String[] strs){
		Map<String, List<String>> anagramMap = new HashMap<>();
		for(String str : strs) {
			char[] carr = str.toCharArray();
			Arrays.sort(carr);
			String key = new String(carr);
			anagramMap.compute(key, (k, v) -> (v == null) ? new ArrayList<>() : v).add(str);
		}
		return new ArrayList<>(anagramMap.values());
	} 
	
	
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
//		System.out.println(Arrays.toString(getSetBits(5)));
//		System.out.println(countSetBits(10));
//		System.out.println(maxSumSubArray(new int[] {5,4,-1,7,8}));
	}
}



