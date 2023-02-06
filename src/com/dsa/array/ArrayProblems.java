package com.dsa.array;

import java.util.List;

public class ArrayProblems {
	
	
	
	/*
	 * EASY -->
	 * 
	 * PROBLEM 1:
	 * 
	 * given an integer arr nums of length n, create a array ans of length
	 * 2n, where ans[i] == nums[i] and ans[i + n] == nums[i], for 0<=i<=n.
	 * ans is the concatenation of two nums arrays;
	 * 
	 * ACCEPTED
	 * runtime - 1ms - beats 97%
	 * memory - 42.9mb - beats - 65%
	 * */
	public static int[] getConcatenation(int[] nums) {
		int len = 2*nums.length;
		int[] ans = new int[len];
		int countlen = nums.length;
		for(int i=0; i<countlen; i++) {
			ans[i] = nums[i];
			if(i==countlen-1) {
				int k = 0;
				for(i=countlen; i<len; i++) {
					ans[i] = nums[k];
					k++;
				}
			}
		}
		return ans;
	}
	
	
	/*
	 * PROBLEM 2:
	 * 
	 * there is a programming language with only one variable X and four 
	 * operations --X, X--, ++X, X++,
	 * given a array of string operations, return the final value of X  
	 * 
	 * */
	public static int finalValueAfterOperations(String[] operations) {
		int var = 0;
		for(int i=0; i<operations.length; i++) {
			switch(operations[i])
			{
			case "++X":
				var += 1;
				break;
			case "X++":
				var +=1;
				break;
			case "--X":
				var -=1;
				break;
			case "X--":
				var -=1;
				break;
			}
		}
		return var;
	}
	
	
	/*
	 * PROBLEM 3(Array 1470):
	 * 
	 * given the array nums consisting of 2n elements in the form [x1,x2,..,xn,y1,y2,..,yn].
	 * return the array of the form [x1,y1,x2,y2,..,xn,yn]
	 * 
	 * -> can the array be empty ->> supposedly no
	 * -> can the n be out out of bounds ->> supposedly no
	 * -> can n be the last index ->> may be
	 * -> do i have to do this in place ->> supposedly you can, but not mandatory
	 * example:
	 * 
	 * [2,5,1,3,4,7],3 -> [2,3,5,4,1,7]
	 * [1,2,3,4,4,3,2,1],4 -> [1,4,2,3,3,2,4,1]
	 * 
	 * steps:
	 * so, to approach the problem in a simple way at first:
	 * 
	 *  1. i will create a new array of same length
	 *  2. iterate nums till n and fill up the new array every consecutive element with nums elements
	 *  3. i will iterate nums from n, and fill up the new array from index 1 and every second index with nums elements.
	 *  
	 * 
	 * */
	public static int[] shuffle(int[] nums, int n) {
		int[] base = new int[nums.length];
		int j = 0;
		for(int i=0; i<n; i++) {
			base[j] = nums[i];
			j+=2;
		}
		int k = 1;
		for(int i=n; i<nums.length; i++) {
				base[k] = nums[i];
				k+=2;
		}
		return base;
	}
	
	/*
	 * PROBLEM 4(Array 1480) : Running sum of 1d Array
	 * 
	 * given an array nums return the running sum.
	 * 
	 * example:
	 * in: [1,2,3,4]
	 * out: [1,3,6,10]
	 * 
	 * */
	public static int[] runningSum(int[] nums) {
		int lastSum = 0;
		int k = 0;
		for(int i=1; i<nums.length; i++) {
			lastSum = nums[i];
			lastSum = lastSum + nums[k];
			nums[i] = lastSum;
			k++;
		}
		return nums;
	}
	
	
	/*
	 * PROBLEM 5: ARRAY 1512
	 * Good Pairs
	 * 
	 * Accepted
	 * 
	 * running time = 1ms beats 87.2%
	 * mem = 9 mb beats 72%
	 * 
	 * */
	public static int numIdenticalPairs(int[] nums) {
		int goodPairs = 0;
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i]==nums[j] && i < j) {
					goodPairs++;
				}
			}
		}
		return goodPairs;
	}
	
	/*
	 * PROBLEM 6: Array 1672 : Richest Wealth Customer
	 * 
	 * runtime : beats 38%
	 * memory : beats 17%
	 * */
	public static int maxWealth(int[][] accounts) {
		int[] cusWealths = new int[accounts.length];
		int maxWealth = 0;
		for(int i=0; i<accounts.length; i++) {
			int wealth = 0;
			for(int j=0; j<accounts[i].length; j++) {
				wealth += accounts[i][j];
			}
			cusWealths[i] = wealth;
		}
		for(int w : cusWealths) {
			if(w > maxWealth) {
				maxWealth = w;
			}
		}
		return maxWealth;
	}
	
	
	public static int maxWealthRE(int[][] accounts) {
		int maxWealth = 0;
		for(int i=0; i<accounts.length; i++) {
			int sum = 0;
			for(int j=0; j<accounts[i].length; j++) {
				sum = sum + accounts[i][j];
			}
			if(sum > maxWealth) {
				maxWealth = sum;
			}
		}
		return maxWealth;
	}
	
	
	/*
	 * PROBLEM 7 : ARRAY : 2535 : Difference betn element sum and digit sum
	 * 
	 * */
	public static int differenceOfSum(int[] nums) {
		int elementsSum = 0;
		int digitsSum = 0;
		for(int i=0; i<nums.length; i++) {
			elementsSum = elementsSum + nums[i];
			if(nums[i] <= 9) {
				digitsSum = digitsSum + nums[i];
			}
			if(nums[i] == 10) {
				digitsSum = digitsSum + 1;
			}
			if(nums[i] > 10) {
				int num = nums[i];
				while(num > 0) {
					int rem = num % 10;
					digitsSum = digitsSum + rem;
					num = num / 10;
				}
			}
		}
		return elementsSum - digitsSum;
	}
	
	/*
	 * PROBLEM 8 : Maximum number of words found in a sentence
	 * 
	 * given a array of sentences, return the number of words 
	 * in a sentence
	 * */
	public static int mostWordsFound(String[] sentences) {
		int maxWords = 0;
		for(String sentence : sentences) {
			String[] words = sentence.split(" ");
			if(words.length > maxWords) {
				maxWords = words.length;
			}
		}
		return maxWords;
	}
	
	/*
	 * P9 : ARR 1365 : HOW MANY NUMBERS ARE SMALLER
	 * 
	 * */
	public static int[] smallerNumberThanCurrent(int[] nums) {
		
		int[] count = new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			int countMins = 0;
			for(int j=0; j<nums.length; j++) {
				if(nums[j] < nums[i]) {
					countMins++;
				}
			}
			count[i] = countMins;
		}
		return count;
	}
	
	
	/*
	 * P 10 : Create target array in given order
	 * i 0 1 2 3 4
	 * 	[0,1,2,3,4]
	 * in        1
	 * 	[0,1,2,2,1]
	 * j   1   3
	 * 	[0,4,1,3,2]
	 *  
	 * 	[0,4,1,3,2]
	 * 		
	 * */
	public static int[] createTargetArray(int[] nums, int[] index) {
		int[] out = new int[nums.length];
		int i = 0;
		for(i=0; i<index.length; i++) {
			int in = index[i];
			if(i != 0 && i > in) {
				int j = i-1;
				while(j >= in) {
					out[j+1] = out[j];
					j--;
				}
				out[in] = nums[i]; 
			}
			else
				out[in] = nums[i];
		}
		return out;
	}
	
	/*
	 * P 11 : ARR 1528 : SHUFFLE STRING
	 * 
	 * */
	public static String restoreString(String s, int[] indices) {
		char[] carr = new char[s.length()];
		if(s.length() != indices.length) {
			return null;
		}
		for(int i=0; i<indices.length; i++) {
			char mapC = s.charAt(i);
			int mapI = indices[i];
			carr[mapI] = mapC;
		}
		return new String(carr);
	}
	
	/**
	 * P 12 : ARR 1773 : Count items matching rule
	 * */
	public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		
		
		return -1;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
	
		String s = "codeleet";
		int[] ind = {4,5,6,7,0,1,2,3};
		System.out.println(restoreString(s, ind));
	}
}
