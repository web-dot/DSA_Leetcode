package com.dsa.binarytree;

class TreeNode{
	int data;
	TreeNode left, right;
	public TreeNode(int data) {
		this.left = this.right = null;
	}
}

public class BinaryTreeSimpleProblemsFromChatGPT {	
	
	/**
	 * P1:
	 * Given a binary tree, write a function to count the number of nodes in the tree.
	 * */
	public static int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	/**
	 * P2:
	 * Given a binary tree, write a function to find the maximum depth of the tree
	 * */
	public static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	
	public static void main (String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		
//		System.out.println(countNodes(node));
		System.out.println(maxDepth(node));
	}
}
