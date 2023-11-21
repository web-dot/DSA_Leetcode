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
	
//	 dynamic programming
//	 longest common sub-sequence:
//	 given two strings, txt1 and txt2, return length of longest subsequence
/**
 * 1. create a 2d table `dp` where dp[i][j] represents the length of the LCS of the 
 * first i characters of sequence X and the first j characters of sequence Y
 * 
 * 2. For each i from 1 to m(length of X) and each j from 1 to n(length of Y) :
 * 		if X[i-1] is equal to Y[j-1], then dp[i][j] = dp[i-1][j-1]+1
 * 		otherwise dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 * 
 * The length of the LCS is given by dp[m][n], where m and n are the lengths of the
 * sequences X and Y, respectively
 * */	
	public static int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length()+1][text2.length()+1];
		// Filling in the table
		for(int i=1; i<=text1.length(); i++){
			for(int j=1; j<=text2.length(); j++) {
				if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
				}
			}
		}
		return dp[text1.length()][text2.length()];
	}
	
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));
//		System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
//		System.out.println(Arrays.toString(getSetBits(5)));
//		System.out.println(countSetBits(10));
//		System.out.println(maxSumSubArray(new int[] {5,4,-1,7,8}));
	}
}



