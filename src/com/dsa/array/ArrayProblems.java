package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		int count = 0;
		for(List<String> item : items) {
			if(ruleKey.equals("type") && ruleValue.equals(item.get(0))) {
				count++;
			}
			else if(ruleKey.equals("color") && ruleValue.equals(item.get(1))) {
				count++;
			}
			else if(ruleKey.equals("name") && ruleValue.equals(item.get(2))) {
				count++;
			}
		}
		return count;
	}
	
	public static int sumOddLengthSubarrays1(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			List<Integer> subList = new ArrayList<>();
			for(int j=i; j<arr.length; j++) {
				subList.add(arr[j]);
				if(subList.size()%2 == 1) {
					sum = sum + subList.stream().mapToInt(Integer::intValue).sum();
				}
			}
		}
		return sum;
	}
	
	//REFACTOR
	public static int sumOddLengthSubarrays(int[] arr) {
		int result = 0;
		int limit = 1;
		while(limit <= arr.length) {
			for(int i=0; i < arr.length - limit + 1; i++) {
				for(int j=i; j<i+limit; j++) {
					result += arr[j];
				}
			}
			limit += 2;
		}
		return result;
	}
	
	
	/**
	 * P 13 : ARR 1662 : check if two string arrays are equivalent
	 * 
	 * */
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		for(String st1 : word1) {
			s1.append(st1);
		}
		for(String st2 : word2) {
			s2.append(st2);
		}
		return s1.toString().equals(s2.toString());
	}
	
	
	/**
	 * P14 : Truncate sentence
	 * 
	 * steps:
	 * -> convert the string into a string array
	 * -> concatenate the k-1 elements with a space and return
	 * 
	 * */
	public static String truncateSentence(String s, int k) {
		String[] sarr = s.split(" ");
		String out = "";
		for(int i=0; i<k; i++) {
			out = out + sarr[i] + " ";
		}
		return out.trim();
	}
	
	
	/**
	 * P15 : ARR 2006 : count number of pairs with absolute difference k
	 * 
	 * */
	public static int countKDifference(int[] nums, int k) {
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(Math.abs(nums[i]-nums[j]) == 2) {
					count++;
				}
			}
		}
		return count;
	} 
	
	/**
	 * P16 : ARR 1684 : allowed, words, consistent
	 * 
	 * */
	public static int countConsistentString(String allowed, String[] words) {
		int count = 0;
		for(String s : words) {
		    boolean isConsistent = true;
		    for (int i = 0; i < s.length(); i++) {
		        char c = s.charAt(i);
		        if (!allowed.contains(String.valueOf(c))) {
		            isConsistent = false;
		            break;
		        }
		    }
		    if (isConsistent) {
		        count++;
		    }
		}
		return count;
	}
	
	
	
	/**
	 * P17 : ARR (youtube Exponent channel problem) : 
	 * 
	 * given an array on n integers construct product array of
	 * the same size such that the [i]th element of the product array
	 * is equal to the of all the elements of the original array except
	 * for the [i]th element
	 * 
	 * */
	public static int[] getProductArray(int[] nums) {
		int[] productArr = new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			int product = 1;
			for(int j=0; j<nums.length; j++) {
				if(i==j) {
					product = product * 1;
				}
				else {
					product = product * nums[j];
				}
			}
			productArr[i] = product;
		}
		return productArr;
	}
	
	//optimizing
	public static int[] getProductArrayOptim(int[] arr) {
		int len = arr.length;
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		int[] product = new int[arr.length];
		
		//[1,2,3,4,5] [1,1,1,1,1]
		/**
		 * build left hand array ->
		 * for each position in the array we want to
		 * take product of everything that came before it
		 * excluding the current position
		 * 
		 */
		for(int i=1; i<len; i++) {
			left[i] = left[i - 1] * arr[i - 1]; 
		}
		
		/**
		 * build right hand array ->
		 * for right hand array we are going to move backwards
		 * */
		for(int i=len-2; i>=0; i--) {
			right[i] = right[i + 1] * arr[i + 1];
		}
		
		/**
		 * build product array from subarrays
		 * */
		for(int i=0; i<len; i++) {
			product[i] = left[i] * right[i];
		}
		return product;
	}
	
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {-1,-2,-3,-4};
		int[] arr3 = {0,2,3,4};
		int[] arr4 = {0,2,0,0};
		
		int[] proarr = getProductArrayOptim(arr1);
		System.out.println(Arrays.toString(proarr));
	}
}
