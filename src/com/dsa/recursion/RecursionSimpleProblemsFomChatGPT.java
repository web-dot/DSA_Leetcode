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
    
    /**sum of all the numbers from 1 to n*/
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
    
    /**write a recursive function that calculates the nth Fibonnaci number*/
    
    public static int fibonnaci(int n){
      System.out.println(n);
      if(n==0 || n==1){
         return n;
      }
      else{
         int n1 = fibonnaci(n-1);
         System.out.println("n1 = " + n1);
         int n2 = fibonnaci(n-2);
         System.out.println("n2 = " + n2);
         int nthFib = n1 + n2;
         System.out.println("fib = " + nthFib);
         return nthFib;
      }  
    }
    
    /**
         5           // n = 5, initial call to the function
         4           // n = 4, first recursive call to fibonacci(n-1)                  
         3           // n = 3, second recursive call to fibonacci(n-1)
         2           // n = 2, third recursive call to fibonacci(n-1)
         1           // n = 1, fourth recursive call to fibonacci(n-1)
         n1 = 1      // n1 = fibonnaci(n-1) where n = 2, returns 1
         0           // n = 0, fifth recursive call to fibonacci(n-2)
         n2 = 0      // n2 = fibonnaci(n-2) where n = 1, returns 0
         fib = 1     // nthFib = n1 + n2, where n = 2, returns 1
         n1 = 1      // n1 = fibonnaci(n-1) where n = 3, returns 1
         1           // n = 1, sixth recursive call to fibonacci(n-2)
         n2 = 1      // n2 = fibonnaci(n-2) where n = 2, returns 1
         fib = 2     // nthFib = n1 + n2, where n = 3, returns 2
         n1 = 2      // n1 = fibonnaci(n-1) where n = 4, returns 2
         2           // n = 2, seventh recursive call to fibonacci(n-2)
         1           // n = 1, eighth recursive call to fibonacci(n-2)
         n1 = 1      // n1 = fibonnaci(n-1) where n = 2, returns 1
         0           // n = 0, ninth recursive call to fibonacci(n-2)
         n2 = 0      // n2 = fibonnaci(n-2) where n = 1, returns 0
         fib = 1     // nthFib = n1 + n2, where n = 2, returns 1
         n2 = 1      // n2 = fibonnaci(n-2) where n = 3, returns 1
         fib = 3     // nthFib = n1 + n2, where n = 4, returns 3
         n1 = 3      // n1 = fibonnaci(n-1) where n = 5, returns 3
         3           // n = 3, tenth recursive call to fibonacci(n-2)
         2           // n = 2, eleventh recursive call to fibonacci(n-2)
         1           // n = 1, twelfth recursive call to fibonacci(n-2)
         n1 = 1      // n1 = fibonnaci(n-1) where n = 2, returns 1
         0           // n = 0, thirteenth recursive call to fibonacci(n-2)
         n2 = 0      // n2 = fibonnaci(n-2) where n = 1, returns 0
         fib = 1     // nthFib = n1 + n2, where n = 2, returns 1
         n1 = 1      // n1 = fibonnaci(n-1) where n = 3, returns 1
         1           // n = 1, fourteenth recursive call to fibonacci(n-2)
         n2 = 1      // n2 = fibonnaci(n-2) where n = 2, returns 1
         fib = 2     // nthFib = n1 + n
         
         +-------------------------+
         | fibonacci(0) : returns 0|
         +-------------------------+
         | fibonacci(1) : returns 1|
         +-------------------------+
         | fibonacci(2) : returns 1|
         +-------------------------+
         | fibonacci(3) : returns 2|
         +-------------------------+
         | fibonacci(4) : returns 3|
         +-------------------------+


    */
    
    
    /**reverse a linked list -> iterative*/
    public static Node reverseList(Node head){
      Node prev = null;
      Node next = null;
      Node curr = head;
      while(curr != null){
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }
      head = prev;
      return head;
    }
    
    /**reverse a linked list -> recursively*/
    
    /**running infinite: refactor after understanding correctly*/
    public static Node reverse(Node curr, Node prev){  
      if(curr == null){
         return prev;
      }
      Node next = curr.next;
      curr.next = prev;
      return reverse(next, curr);
    }
    
    /**
    fibonnachi
      each number is the sum of two prceeding numbers.
      given n calculate F(n)
    */
    public static int fib(int n){
      if(n == 0){
         return 0;
      }
      if(n == 1){
         return 1;
      }
      return (fib(n-1) + fib(n-2));
    }
    
    
    
	public static void main(String[] args) {
	    int x = 5;
      System.out.println(fib(x));
	}
}

class Node{
   int val;
   Node next;
   public Node(int val){
      this.val = val;
      this.next = null;
   }
}
