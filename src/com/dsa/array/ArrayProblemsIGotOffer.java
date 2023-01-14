package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayProblemsIGotOffer {

	/* Steps to program - Book2-p167 */

	/*
	 * LeetCode: 283
	 * 
	 * Given an integer array, move all elements that are 0 to the end, while
	 * maintaining order of the other elements in the array. The array has to be
	 * modified in place.
	 * 
	 */

	/*
	 * Algorithm1 result: fails on some cases
	 */
	public static int[] moveAllZerosToEndA1(int[] arr) {

		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] == 0) {
				if (arr[end] != 0) {
					int temp = arr[start];
					arr[start] = arr[end];
					arr[end] = temp;
				} else
					end--;
			} else
				start++;

		}
		return arr;
	}

	/*
	 * Algorithm2
	 * 
	 * 
	 */
	public static int[] moveAllZerosToEndA2(int[] arr) {

		int indexAfterOccupied = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[indexAfterOccupied];
				arr[indexAfterOccupied] = arr[i];
				arr[i] = temp;
				indexAfterOccupied++;
			}
		}
		return arr;
	}

	/*
	 * LeetCode: 704
	 * 
	 * Given an array of integers nums, which is sorted in ascending order, and an
	 * integer target, write a function to search target in nums. If target exists,
	 * then return its index, Otherwise return -1. You must write an algorith with
	 * (Ologn) runtiume complexity.
	 * 
	 */
	public static int searchTarget(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;

		
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				return mid;
			}
			if (target > nums[mid]) {
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return -1;
	}
	
	/*
	 * Scaler Test: Minimum possible maximum sum
	 * 
	 *You have an array of 10 integers: [19,81,2,41,61,59,28,69,76,88]. Find a way to divide these 
	 *integers into 5 pairs, such that, if you add up the numbers in each pair, then the maximum
	 *sum among the 5 pairs is minimized. What is the minimum possible maximum sum?
	 * 
	 */
	
	
	/*
	 * Given an integer array nums, return true if any value appears at least twice in the array,
	 * and return false if every element is distinct.
	 * 
	 * */
	public static boolean containsDuplicate(int[] nums) {
		
		Arrays.sort(nums);
		
		boolean hasDuplicate = false;
		for(int i = 0; i < nums.length; i++) {
			int low = i+1;
			int high = nums.length - 1;
			while(low <= high) {
				int mid = low + (high - low) / 2;
				if(nums[i] == nums[mid]) {
					hasDuplicate = true;
				}
				if(nums[i] > nums[mid]) {
					low = mid + 1;
				}
				else
					high = mid - 1;
			}
		}
		return hasDuplicate;
	}
	
	public static boolean containsDuplicateUsingSet(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i : nums) {
			set.add(i);
		}
		if(set.size() != nums.length) {
			return true;
		}
		return false;
	}
	
	/*
	 * Given an array A of size N. You need to find the sum of
	 * Maximum and Minimum element in the give array. You should make minimum
	 * number of comparisons.
	 * 
	 * */
	public static int maxMinSum(ArrayList<Integer> A) {
		Collections.sort(A);
		return A.get(0) + A.get(A.size() - 1);
	}

	public static void main(String[] args) {

		
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-2, 1, -4, 5, 3));
		System.out.println(maxMinSum(arr));
		

		/*
		int[] arr = new int[] {1,2,3,4};
		System.out.println(containsDuplicate(arr));
		//System.out.println(containsDuplicateUsingSet(arr));
		*/
		
		/*
		int[] arr1 = new int[] {-1, 0, 3, 5, 9, 12};
		int result = searchTarget(arr1, 2);
		System.out.println(result);
		*/
		
		/*
		int[] arr7 = new int[] { 1, 10, 20, 0, 59, 63, 0, 88, 0 }; // passed in leetcode
		int[] result1 = moveAllZerosToEndA2(arr7);
		*/
	}

}
