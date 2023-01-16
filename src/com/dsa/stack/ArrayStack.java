package com.dsa.stack;

public class ArrayStack {
	
	private int[] items = new int[3];
	private int top = 0;
	
	public void push(int num) {
		if(top == items.length) {
			System.out.println("stack is full");
		}
		else {
			items[top] = num;
			top++;
		}
	}
	
	public int pop() {
		if(top == 0) {
			System.out.println("stack is empty");
		}
		else {
			int topItem = items[top-1]; // getting the value of top
			items[top - 1] = 0; // setting the value of top to default
			top--;				//
			return topItem;
		}
		return 0;
	}
	
	public int top() {
		if(top == 0) {
			System.out.println("stack is empty");
		}
		else {
			return items[top - 1];
		}
		return -1;
	}
}
