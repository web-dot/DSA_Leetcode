package com.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;

class LocalNode{
	int data;
	LocalNode left, right;
	public LocalNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

/*
 * write a program to print the left view of binary tree
 * 
 * */

class leftViewOfTree {
	
	int maxLevel = 0;
	void leftView(LocalNode root, int level, List<Integer> result) {
		if(root == null) {
			return;
		}
		
		if(maxLevel < level) {
			result.add(root.data);
			maxLevel = level;
		}
		
		leftView(root.left, level + 1, result);
		leftView(root.right, level + 1, result);
		
	}
}

public class BinaryTreeLeftViewProblem {
	
	public static void main(String[] args) {
		LocalNode root = new LocalNode(1);
		root.left = new LocalNode(2);
		root.right = new LocalNode(3);
		root.right.left = new LocalNode(6);
		root.right.right = new LocalNode(4);
		
		List<Integer> result = new ArrayList<>();
		leftViewOfTree instance = new leftViewOfTree();
		instance.leftView(root, 1, result);
		
		for(Integer integer : result) {
			System.out.print(integer + " ");
		}
	}

}
