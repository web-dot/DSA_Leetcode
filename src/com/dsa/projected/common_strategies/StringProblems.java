package com.dsa.projected.common_strategies;

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

	//kadens algorithm
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
	
	public static void main(String[] args) {
		System.out.println(maxSumSubArray(new int[] {5,4,-1,7,8}));
	}
}
