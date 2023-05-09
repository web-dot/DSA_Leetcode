package com.dsa.doubly_llinked_list;

public class DoublyLinkedList {

	Node head;
	Node runner;
	
	
	public DoublyLinkedList(Node node) {
		this.head = node;
	}
	
	public Node addAtBeginning(Node node) {
		node.next = head;
		head.prev = node;
		head = node;
		return head;
	}
	
	public void addAtEnd(Node node) {
		runner = head;
		while(runner.next != null) {
			runner = runner.next;
		}
		runner.next = node;
		node.prev = runner.next;
	}
}
