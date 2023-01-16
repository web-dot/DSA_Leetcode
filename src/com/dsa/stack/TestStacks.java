package com.dsa.stack;

public class TestStacks {

	
	public static void main(String[] args) {
	
		StackX theStackX = new StackX(10);
		theStackX.push(20);
		theStackX.push(40);
		theStackX.push(60);
		theStackX.push(80);
		
		while(!theStackX.isEmpty()) {
			long value = theStackX.pop();
			System.out.println(value);
		}
		
	}
}
