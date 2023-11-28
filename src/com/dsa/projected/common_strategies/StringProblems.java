package com.dsa.projected.common_strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
	
	// Greedy algorithm :
	// a greedy algorithm makes the best possible decision at each step,
	// hoping that this will lead to the overall best solution
	
	/**
	 * classic problem : coin change problem: given a set of coin denominations and a target amount,
	 * find the number of coins needed to make up that amount
	 * approach: to pick the largest coin that is smaller than the remaining amount at each step.
	 * 
	 * consider the coin denominations{1,5,10,25} and the target amount is 30
	 * 
	 * 1. select the largest coin(25) that is smaller than the remaining amount(30). Subtract
	 * 25 from 30, and the remaining amount is now 5.
	 * 2. select the largest coin(5) that is smaller than the remaining amount(5). subtract 5 from
	 * 5, and the remaining amount is now 0.
	 * 
	 * The chosen coins are 25 and 5, and the total number of coins is 2. This is the optimal solution
	 * in this case.
	 * */
	
	// given a string s, rearrange the characters of s so that any two adjacent characters are
	// not the same
	public static String reorganizeString(String s) {
		// step1 : count the frequency of each character
		Map<Character, Integer> freqMap = new HashMap<>();
		for(char ch:s.toCharArray()) {
			freqMap.compute(ch, (k, v) -> v == null ? 1 : v + 1);
		}
		
		// step2: create max heap using a priority-queue ans a custom comparator
		PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                Comparator.<Character, Integer>comparing(freqMap::get).reversed()
        );
		
		// step3: build the rearranged string
		StringBuilder result = new StringBuilder();
		
		// add all character to the max heap
		maxHeap.addAll(freqMap.keySet());
		
		while(!maxHeap.isEmpty()) {
			char current = maxHeap.poll(); // get the character with highest frequency
			result.append(current);
			
			// update the freq map
			freqMap.put(current, freqMap.get(current) - 1);
			
			// if there are still occurances left, add the character back to the max-heap
			if(freqMap.get(current) > 0) {
				maxHeap.add(current);
			}
		}
		return result.toString();
	}
	
	// greedy algorithm - example 2
	// suppose you have set of activities with start and end time. the goal is to select 
	// maximum number of non-overlapping activities
	/**
	 * step1: sort the activities based on their end times
	 * step2: select the first activity
	 * step3: for each remaining activity, choose it if its start time is greater than or
	 * equal to the end time of the previously selected activity.
	 *  
	 * */
	
	
	
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));
//		System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
//		System.out.println(Arrays.toString(getSetBits(5)));
//		System.out.println(countSetBits(10));
//		System.out.println(maxSumSubArray(new int[] {5,4,-1,7,8}));
	}
}



