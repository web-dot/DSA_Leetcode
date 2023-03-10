package com.dsa.binarytree;

class StringNode {
	String data;
	StringNode left, right;

	public StringNode(String data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class BinaryTreeTraversal {

	public static void preOrderTraversal(StringNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public static void inorderTraversal(StringNode node) {
		if(node != null) {
			inorderTraversal(node.left);
			System.out.print(node.data + " ");
			inorderTraversal(node.right);
		}
	}

	public static void main(String[] args) {
		StringNode root = new StringNode("A");
		root.left = new StringNode("B");
		root.left.left = new StringNode("D");
		root.left.right = new StringNode("E");
		root.right = new StringNode("C");
		root.right.right = new StringNode("F");
		
		preOrderTraversal(root);
		System.out.println();
		inorderTraversal(root);
	}

}
