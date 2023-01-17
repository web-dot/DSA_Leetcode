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
		
		
		/*reverse a word*/
		
		String input = "Hello";
		String output = "";
		int stackSize = input.length();
		StackForChar stack = new StackForChar(stackSize);
		
		for(int j=0; j<input.length(); j++) {
			char c = input.charAt(j);
			stack.push(c);
		}
		
		while(!stack.isEmpty()){
			char ch = stack.pop();
			output = output + ch;
		}
		
		
		System.out.println(output);
		
		
		
		
		
		
		
		
	}
}
