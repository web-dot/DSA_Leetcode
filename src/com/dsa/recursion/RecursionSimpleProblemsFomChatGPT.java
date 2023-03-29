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
	
	public static void main(String[] args) {
		int n = 5;
      countdown(5);
	}
}
