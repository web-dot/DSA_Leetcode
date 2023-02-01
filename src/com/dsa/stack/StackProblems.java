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
		
		char[] ch1 = s.toCharArray();
		for(int i=0; i<ch1.length; i++) {
			if(ch1[i] != '#') {
				stack1.push(ch1[i]);
			}
			if(ch1[i] == '#' && !stack1.isEmpty()) {
				stack1.pop();
			}
			if(i == 0 && ch1[i] == '#') {
				char temp = ch1[i];
				ch1[i] = ch1[i+1];
				ch1[i+1] = temp;
			}
		}
		
		char[] c1 = new char[100];
		int k=0;
		while(!stack1.isEmpty()) {
			c1[k] = stack1.pop();
			k++;
		}
		String s1 = new String(c1);
		
		char[] ch2 = t.toCharArray();
		for(int j=0; j<t.length(); j++) {
			if(ch2[j] == '#' && stack1.isEmpty()) {
				
			}
			if(ch2[j] != '#') {
				stack2.push(ch2[j]);
			}
			if(ch2[j] == '#' && !stack2.isEmpty()) {
				stack2.pop();
			}
			if(j == 0 && ch2[j] == '#') {
				char temp = ch1[j];
				ch1[j] = ch1[j+1];
				ch1[j+1] = temp;
			}
		}
		
		char[] c2 = new char[100];
		int l = 0;
		while(!stack2.isEmpty()) {
			c2[l] = stack2.pop();
			l++;
		}
		
		String s2 = new String(c2);
		
		return s1.equals(s2);
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		String s = "pnsu#aalutur####egfb##ta#y##guqftkkcz"; 
		String t = "pnsu#aalutub#n#r####p#egfb##taj##y##guqftku#kl#cz";
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
