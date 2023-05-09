package com.dsa.doubly_llinked_list;

public class Node {
	int val;
	Node prev;
	Node next;
	public Node(int val) {
		this.val = val;
		this.prev = this.next = null;
	}
}
