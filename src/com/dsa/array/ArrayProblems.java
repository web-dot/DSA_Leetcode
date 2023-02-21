package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	
	
	/**
	 * P18 : ARR (youtube Exponent channel problem : good subarray) : 
	 * 
	 * let's say you are given an integer array nums and a integer k, return true
	 * if nums has a good subarray or false otherwise.
	 * 
	 * a good subarray is a subarray where:
	 * its length is at least two, and
	 * the sum of the elements of the subarray is a multiple of k
	 *
	 *	[23,2,4,6,7], k=6 -> true
	 *
	 *	[2,1,3,6] -> 3 -> true
	 * 	[7,2,4,5] -> 7 -> true
	 * 	[7,2,4,3] -> 7 -> false
	 * 
	 * */
	public static boolean kDivisorOfSubarray(int[] arr, int k) {
		for(int i = 0; i<arr.length; i++) {
			int p1 = i;
			int p2 = arr.length-1;
			List<Integer> inter = new ArrayList<>();
			inter.add(arr[i]);
			while(p1<p2) {
				inter.add(arr[p2]);
				p2--;
				System.out.println(inter);
				double sum = inter.stream().mapToInt(value -> value.intValue()).sum();
				if(sum % k == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * insertion sort
	 * */
	public static int[] insertionSort(int[] nums) {
		for(int i=0; i<nums.length; i++){
			int temp = nums[i];
			int j = i - 1;
			//1,2,4,2,3
			while(j >= 0 && nums[j] > temp ) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j + 1] = temp;
		}
		return nums;
	}
	
	/**
	 * P19: ARR 2089 : find target indices after sorting array
	 * */
	public static List<Integer> targetIndices(int[] nums, int target){
		int[] result = insertionSort(nums);
		int start = 0;
		int end = result.length-1;
		List<Integer> indexList = new ArrayList<>();
		while(start < end) {
			int mid = end + (start-end) / 2;
			if(result[mid] == target) {
				indexList.add(mid);
			}
			if(target > result[mid]) {
				start = mid + 1;
			}
			if(target < result[mid]) {
				end = mid - 1;
			} 
		}
		Collections.sort(indexList);
		return indexList;
	}
	
	
	/**
	 * P20 : ARR 1913 : maximum product difference between two pairs
	 * 5,6,2,7,4
	 * */
	public static int[] newInsertionSort(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			int temp = nums[i];
			int j = i - 1;
			while(j >= 0 && nums[j] > temp) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j + 1] = temp;
		}
		return nums;
	}
	
	
	public static int maxProductDifference(int[] nums) {
		int[] sorted = newInsertionSort(nums);
		return (sorted[sorted.length-2] * sorted[sorted.length-1]) - (sorted[0] * sorted[1]);
	}
	
	
	

	public static void main(String[] args) {
		int[] nums = {9012,8883,4758,4915,2581,2853,5923,8336,3674,1989,3293,2276,3879,8095,431,5913,9078,9377,6045,7658,9039,2127,1413,1078,5068,6524,7843,8613,6731,6709,9420,1209,2054,5195,1216,7373,7633,8477,5645,2103,9033,9631,2982,2115,7089,8239,908,2035,8489,2508,4983,2698,2654,5287,3695,5670,8502,4654,1293,4106,3217,9025,4497,2051,4962,8741,1531,8235,2763,9697,9514,2527,2805,9915,5532,9235,675,465,1331,745,9450,4337,3454,9374,6826,497,8160,8939,4746,4950,7913,4013,6654,4874,7431,1196,982,2590,7203,6810,7934,7610,3343,5574,9940,2354,5122,5232,5659,6533,2143,6071,8438,9203,1740,5229,3961,7643,2008,4383,7367,4062,2309,1587,830,4755,6294,6851,4068,2617,5365,9465,5124,3111,2611,8164,8434,7649,8172,5056,8149,380,1476,6443,8282,7492,3945,3525,9558,5782,798,829,4610,8109,9790,7711,4682,8794,134,1762,7061,2195,4334,5993,6607,5996,742,6564,839,9344,9205,3190,5940,9065,4729,1205,6330,8262,7379,9009,4583,1947,2109,1585,6454,6115,5556,9140,5991,2364,3262,9871,8342,6577,8194,660,743,638,2246,5457,7762,8509,7488,2441,9933,8447,2291,5374,5219,2663,6439,4903,9728,5512,8312,8352,8722,8026,9223,4912,7781,273,6036,5428,1796,6825,9564,5041,437,9780,7776,4351,9478,9464,3729,842,9561,7872,2794,8590,6230,2422,3969,518,9381,1801,3126,311,7226,5140,6862,2482,6766,3341,6724,8222,7727,1021,2263,8499,3398,9190,5326,7838,8610,6174,5141,2838,7532,8735,5609,8951,5805,4332,9996,7933,3151,4039,4572,9144,4891,3685,4877,4736,3397,8012,5195,7862,5715,9184,4481,4716,1997,9396,8900,6221,6465,5655,2400,4759,690,4713,1295,5675,7248,4202,7850,3506,3311,8825,4443,9209,4451,2250,1790,9615,3921,3973,832,8701,3698,3815,861,1642,6772,5412,7740,1648,2253,85,9017,2588,6667,7794,7823,3268,4707,5263,4677,970,1466,9407,3805,8768,612,2869,6847,2881,596,6505,8117,3053,4743,614,152,4889,9306,9876,1759,5490,4663,7445,8902,8591,8093,2199,8262,7669,4471,3160,1846,5418,2663,7519,4216,3051,231,5524,4834,9303,3165,2876,6644,7008,8443,5373,1422,6568,1563,3028,2304,7823,5302,4065,112,4273,6285,3859,7320,4375,5401,4948,9544,9387,188,4286,5891,3872,1018,1937,7626,5027,2617,6643,8234,5096,1924,4834,6022,3619,3591,2189,7835,2510,7455,9925,6122,6814,8999,7715,8807,3579,4055,9762,1342,8610,7320,8654,5928,1280,9244,1839,1012,8973,8282,3313,9384,8793,2456,2696,5376,8526,7240,1905,3366,9555,8009,1490,8362,7299,912,7430,2162,8410,6807,7485,9240,946,9156,7576,5050,357,6488,4170,50,3571,9476,1197,743,6942,5645,1045,8867,988,1131,7735,520,4704,6699,2949,2219,6888,6136,6267,7349,6185,6155,1315,8836,2179,5698,1944,2925,8803,6440,8665,2087,3649,57,373,4889,7586,8921,6949,8716,6215,3763,4056,7547,5672,2542,4517,3089,1849,528,6869,257,3944,3377,1103,1654,9732,551,7315,9795,798,4010,725,6591,7192,3840,8844,3560,925,2296,8256,4740,3837,9439,5225,9462,9797,5254,3882,4945,2348,8541,3622,6776,4924,4509,999,9122,9694,2870,7000,9108,8121,769,5643,6245,8593,5223,6822,6689,2445,4914,6168,3013,8814,7759,3949,3693,4928,2366,7587,945,9215,6762,6825,9131,8684,2197,6364,3979,4178,3332,5412,1296,7370,6080,1515,8776,3121,845,4399,6180,9912,9879,648,1193,3083,9627,9157,3556,7855,3423,5456,4968,252,3471,3114,1923,7847,3975,9903,3351,6499,3922,9046,5270,4638,6237,7640,8744,5887,5054,4286,5893,8402,8148,7636,1616,7693,5247,3329,6074,5127,6782,750,9217,3626,2391,266,4273,9066,9569,9489,6842,4837,2498,3215,5405,3769,6224,9336,4027,8181,9022,5531,4217,8006,8038,7551,2757,5771,2774,2294,8955,8001,3016,8883,963,8585,555,1218,795,105,6757,2253,3792,1114,2475,150,3584,8286,7472,6115,991,7917,7994,258,109,8720,9039,6740,195,275,8674,4502,8778,4698,281,8229,7055,2938,1754,1579,8592,2440,3949,3145,8626,4136,5808,4380,6503,1295,6113,6653,7521,9257,3985,3701,4915,1321,520,1532,6641,6214,6180,9056,7799,920,155,2808,1355,8190,7110,5428,9271,1563,8654,698,3765,3464,9287,7791,4442,763,1219,4594,8898,9233,540,2939,5153,257,3395,9618,2363,6526,1261,4904,2662,9240,3940,9285,6376,8857,5436,6289,2293,1285,8205,5667,880,1601,7162,3804,1246,5581,9916,9759,6500,5348,486,4479,7382,8039,3738,5830,9061,6151,7076,3044,9599,6228,1405,4840,4038,1205,1345,4391,2527,6226,2528,6384,5189,5910,1746,1500,86,5051,7287,5897,4420,1675,2171,1431,3071,7062,7354,9126,9089,8396,6686,1693,431,1469,5799,9081,1525,9781,9799,5316,6312,203,4782,6780,6354,1388,9168,3978,9371,8538,2779,6238,2778,2275,4406,4934,4398,8080,2391,1037,2740,7122,4522,6900,4912,7934,1261,5917,4124,4041,8124,9729,3204,7502,1753,2220,4992,111,6484,5444,6225,5400,7213,5485,7056,9739,2231,4923,5254,9884,3291,7849,5148,2911,6525,5229,4776,8045,9436,3972,5340,6162,4593,6438,5981,1866,9239,3274,9704,8940,2948,9013,441,7564,3435,7184,4774,1134,6704,8181,2281,4962,3966,4140,2526,6933,6177,1212,7358,9797,7852,9540,6567,8756,8301,6854,8908,603,5891,8797,9730,1393,1792,4068};
		System.out.println(maxProductDifference(nums));
 	}
}
