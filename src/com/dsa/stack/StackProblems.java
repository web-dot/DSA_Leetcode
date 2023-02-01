package com.dsa.stack;

import java.time.LocalDateTime;

public class StackProblems {

	/*
	 * PROBLEM 01:
	 * 
	 * Reverse a word.
	 * The problem is solved using the StackForChar class
	 * 
	 * */
	
	
	
	
	/*
	 * PROBLEM 02:
	 * 
	 * Delimeter mathching
	 * 
	 * given a string s containing the characters (, ), {, }, [ and ]
	 * determine if the input string is valid
	 * 
	 * input: ()
	 * output: true
	 * 
	 * input: (]
	 * output: false
	 * */
	
	/*
	 * to solve this problem, 
	 * 1. i am creating a stack, in which i can push a char
	 * 			- i will push the char if it is a opening delimiter
	 * 			- if it is a closing delimiter, i will pop form the stack and check if they match 
	 * */
	
	
	/*
	 *given two strings check if they are are equal, #means backspace 
	 * */
	public static boolean backspaceCompare(String s, String t) {
		StackOfDelm stack1 = new StackOfDelm();
		StackOfDelm stack2 = new StackOfDelm();
		if(s.length() != t.length()) {
			return false;
		}
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(i == 0 && c == '#') {
				return false;
			}
			if(c != '#') {
				stack1.push(c);
			}
			if(c != '#' && !stack1.isEmpty()) {
				stack1.pop();
			}
		}
		
		char[] c1 = new char[10];
		int k=0;
		while(!stack1.isEmpty()) {
			c1[k] = stack1.pop();
			k++;
		}
		String s1 = new String(c1);
		
		for(int j=0; j<t.length(); j++) {
			char c = t.charAt(j);
			if(j == 0 && c == '#') {
				return false;
			}
			if(c != '#') {
				stack2.push(c);
			}
			if(c != '#' && !stack2.isEmpty()) {
				stack2.pop();
			}
		}
		
		char[] c2 = new char[10];
		int l = 0;
		while(!stack2.isEmpty()) {
			c2[l] = stack2.pop();
			l++;
		}
		
		String s2 = new String(c2);
		
		return s1.equals(s2);
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		String s = "a##c"; 
		String t = "#a#c";
		System.out.println(backspaceCompare(s, t));
		
		/*
		 * PROBLEM 1 : Reverse a word
		 * 	
		String input = "progrAmming";
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
		*/
		
		/*Delimiter matching test*/
		
		/*
		StackOfDelm delmStack = new StackOfDelm();
		
		String input = "()";
		int length = input.length();
		boolean val = true;
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			switch(c)
			{
			case '{':
			case '(':
			case '[':
				delmStack.push(c);
				break;
				
			case '}':
			case ')':
			case ']':
				if(delmStack.isEmpty()) {
					val = false;
				}
				if(!delmStack.isEmpty()) {
					char ch = delmStack.pop();
					if(c == ')' && ch != '(' || c == '}' && ch != '{' || c == ']' && ch != '[') {
						val = false;
					}
				}
			}
			
			
		}
		//System.out.println("true");
		if(!delmStack.isEmpty()) {
			val = false;
		}
		System.out.println(val);
		*/
	}
}
