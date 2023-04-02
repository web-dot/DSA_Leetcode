package com.dsa.recursion;

public class RecursionSimpleProblemsFomChatGPT {
	  /**
      Understanding recursion
    */
    public static void countdown(int n){
      if(n <= 0){
         System.out.println("Done!");
      }
      else{
         System.out.println(n);
         countdown(n-1);
      }
    }
    
    /**factorial of a positive number*/
    public static int findFactorial(int num){
      if(num == 1){
         return 1;
      }
      else{
         return num * findFactorial(num - 1);
      }  
    }
    
    public static int findSum(int num){
      int sum = 0;
      if(num == 1 ){
         return 1;
      }
      else{
         sum = num + findSum(num - 1);
         System.out.println(sum);
         return sum;
      }
    }
    
	public static void main(String[] args) {
		findSum(5);
	}
}
