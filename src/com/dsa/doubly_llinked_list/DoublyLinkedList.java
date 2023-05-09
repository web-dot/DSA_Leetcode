package com.dsa.doubly_llinked_list;

public class DoublyLinkedList {

	Node head;
	
	public DoublyLinkedList(Node node) {
		this.head = node;
	}
	
	public Node addAtBeginning(Node node) {
		node.next = head;
		head.prev = node;
		head = node;
		return head;
	}
	
//	public Node addAtEnd(Node node) {
//		
//	}
}
