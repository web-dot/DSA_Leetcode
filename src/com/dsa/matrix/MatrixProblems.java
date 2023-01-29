package com.dsa.matrix;

public class MatrixProblems {

	
	/*
	 * PROBLEM 1 : Matrix 2373 : Largest Local Values
	 * 
	 * 
	 * */
	public static int[][] largestLocal(int[][] grid){
		int n = grid.length;
		int[][] largestLocal = new int[n-2][n-2];
		for(int i=0; i<n - 2; i++) {
			int[] a1 = new int[n-2];
			for(int j=0; j<n -2; j++) {
				int max = Integer.MIN_VALUE;
				for(int k=i; k<i+3; k++) {
					for(int l=j; l<j+3; l++) {
						max = Math.max(max, grid[k][l]);
					}
				}
				a1[j] = max;
			}
			largestLocal[i] = a1;
		}
		return largestLocal;
	}
	
	public static void main(String[] args) {
		
		int[][] grid = new int[5][];
		
		int[] arr1 = {1,1,1,1,1};
		int[] arr2 = {1,1,1,1,1};
		int[] arr3 = {1,1,2,1,1};
		int[] arr4 = {1,1,1,1,1};
		int[] arr5 = {1,1,1,1,1};
		
		int[] arr6 = {9,9,8,1};
		int[] arr7 = {5,6,2,6};
		int[] arr8 = {8,2,6,4};
		int[] arr9 = {6,2,2,2};
		
		grid[0] = arr1;
		grid[1] = arr2;
		grid[2] = arr3;
		grid[3] = arr4;
		grid[4] = arr5;
		
//		grid[0] = arr6;
//		grid[1] = arr7;
//		grid[2] = arr8;
//		grid[3] = arr9;
		
		int[][] nums = largestLocal(grid);
		
	}

}
