package com.dsa.doubly_llinked_list;

public class DoublyLinkedListProblems {
	
	public static void main(String[] args) {
		
		Node n1 = new Node(50);
		Node n2 = new Node(40);
		Node n3 = new Node(30);
		Node n4 = new Node(60);
		
		
		DoublyLinkedList doublyList = new DoublyLinkedList(n1);
		
		Node head = doublyList.addAtBeginning(n2);
		head = doublyList.addAtBeginning(n3);
		doublyList.addAtEnd(n4);
		
		Node current = head;
		
		while(current != null) {
			System.out.println(current.val);
			current = current.next;
		}
		
	}
}
