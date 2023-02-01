package com.dsa.stack;

public class StackOfDelm {
	
	char[] charArr = new char[100];
	int top = -1;
	
	public void push(char c) {
		charArr[++top] = c;
	}
	
	public char pop() {
		return charArr[top--];
	}
	
	public char peek() {
		return charArr[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
}
