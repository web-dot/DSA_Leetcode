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
			int topItem = items[top-1];
			top--;
			return topItem;
		}
		return 0;
	}
}
