package com.dsa.search;

import java.util.Arrays;

public class SearchAlgos {
	
	
	/**
	 * Binary Search Algorithm
	 * 
	 * complexity : complexity of an algorithm is the measure of the running time of the algorithm
	 * as a function of the size of the input.
	 * 
	 * complexity of `binary search` algorithm is O(log n), which means that when the size of
	 * the input might double the running time will increase a very less amount as compared to the input.
	 * 
	 *  complexity of a algorithm is measured using the Big O Notation.
	 *  Big O notation is a upper bound to the running time of an algorithm.
	 *  
	 *  As per my understanding Big O notation represents a set of standard functions[f-> f(n), f -> f(log n), f -> f(n^2)], 
	 *  that puts an upper bound to the running time of a algorithm. Which means that if we say that a algorithm
	 *  is O(n), it means that the running time of the algorithm which is a function of the size of the input,
	 *  will under no scenario exceed linear.
	 * 
	 * */
	
	public static int binarySearch(int[] arr, int num) {
		// for binary-search, the array must be sorted
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = start + (end-start) / 2;
			if(arr[mid] == num) {
				return mid;
			}
			if(num < arr[mid]) {
				end = mid - 1;
			}
			else
				start = mid + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,4,1,6,10,3,7,9,5};
	    System.out.println(binarySearch(arr, 6));
	}
}
