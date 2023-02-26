package com.dsa.binarytree;

class TreeNode{
	int data;
	TreeNode left, right;
	public TreeNode(int data) {
		this.data = data;
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
	
	/**
	 * P3:
	 * Given a binary tree, determine if it is a valid binary search tree
	 * BST -> value of each node is: 
	 * 	-> greater than or equal to values of all the nodes in its left subtree
	 * 	-> less than or equal to the values of all the nodes in its right subtree
	 * */
	public static boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, null, null);
	}
	
	public static boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
		if(node == null) {
			return true;
		}
		if((min != null && node.data <= min) || (max != null && node.data >= max)) {
			return false;
		}
		
		boolean leftValid = isValidBSTHelper(node.left, min, node.data);
		boolean rightValid = isValidBSTHelper(node.right, node.data, max);
		
		return leftValid && rightValid;
	}
	
	
	public static void main (String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(3);
		node.right = new TreeNode(7);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(4);
		node.right.right = new TreeNode(9);
		
//		System.out.println(countNodes(node));
//		System.out.println(maxDepth(node));
		System.out.println(isValidBST(node));
	}
}
