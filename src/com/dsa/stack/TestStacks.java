package com.dsa.stack;

public class TestStacks {

	
	public static void main(String[] args) {
		
		ArrayStack s1 = new ArrayStack();
		s1.push(10);
		s1.push(20);
		s1.push(30);
		//s1.push(40);
		
		int x = s1.pop();
		System.out.println(x);
		int y = s1.pop();
		System.out.println(y);
		int z = s1.pop();
		System.out.println(z);
		int k = s1.pop();
	}
}
