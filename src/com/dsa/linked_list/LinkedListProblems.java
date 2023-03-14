package com.dsa.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LinkedListProblems {
	
	/*
	 * PROBLEM 01:
	 * 
	 * You are given two non-empty linked lists representing two non empty 
	 * integers. The digits are stored in reverse order, and each of their 
	 * nodes contains a single digit. Add the two numbers and return the sum
	 * as linked list
	 * The two numbers do not contain any leading 0, except the number 0 itself.
	 *   
	 * */
	public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		
		ListNode dummyHead = new ListNode(0);
		ListNode runner = dummyHead;
		int carry = 0;
		while(list1 != null || list2 != null || carry != 0) {
			
			int x = list1 != null ? list1.val : 0;
			int y = list2 != null ? list2.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			runner.next = new ListNode(sum % 10);
			runner = runner.next;
			if(list1 != null) 
				list1 = list1.next;
			
			if(list2 != null) 
				list2 = list2.next;
		}
		return dummyHead.next;
	}

	/*
	 * PROBLEM 02:
	 * 
	 * Given the head of a linked list, remove the nth node 
	 * from the end of the list and return its head.
	 * 
	 * */
	
	/*
	 * solution 01
	 * 1. set up a pointer p1 to the head of the LL
	 * 2. move p1 to the end of the LL
	 * 3. move p1 n+1 nodes from the end of the LL
	 * 4. set the next pointer of p1 to point to the node after p1's current node
	 * 
	 * */
	
	//REFACTOR
	public static ListNode deleteNthFromEndS1(ListNode head, int n) {
		
		ListNode p1 = head;
		int length;
		
		if(head == null)
			length = 0;
		else
			length = 1;
		
		while(p1.next != null) {
			p1 = p1.next;
			length++;
		}
		System.out.println(p1.val + " : " + length); // here p1 is pointing to last node
		
		
		return null;
	}	
	
	
	/*
	 * PROBLEM 03:
	 * 
	 * you are given the heads of two sorted linke lists list1 nad list2.
	 * Merge the two lists in one sorted list. The list should be made by splicing
	 * together the nodes of the of the first two lists. 
	 * 
	 * */
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		
		ListNode dummy = new ListNode();
		ListNode current = dummy;
		
		ListNode p1 = list1;
		ListNode p2 = list2;
		
		if(p1 == null) {
			return list2;
		}
		if(p2 == null) {
			return list1;
		}
		
		if(p1.next == null && p2.next == null) {
			if(p1.val < p2.val) {
				p1.next = p2;
				return p1;
			}
			else {
				p2.next = p1;
				return p2;
			}
		}
		
		while(p1 != null && p2 != null) {
			if(p1.val < p2.val) {
				current.next = p1;
				p1 = p1.next;
			}
			else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
			
			if(p1 != null) {
				current.next = p1;
			}
			else if(p2 != null) {
				current.next = p2;
			}
		}
		return dummy.next;
	} 
	
	/*
	 * PROBLEM 04:
	 * 
	 * you are given a array of k linked lists, each linked-list is sorted in ascending order.
	 * Merge all the linked-lists into one sorted linked-list and return it.
	 * 
	 * steps:
	 * 
	 * 1. 	Create a main function that takes in the array of LL
	 * 2. 	Inside the main function use a divide and conquer approach to recursively
	 * 		divide the array into smaller sub-arrays.
	 * 3. 	Use a helper function that takes in the array of LL and the start and end indices
	 * 		of the sub-array.
	 * 4. 	The helper function recursively divides the sub array of linked lists into two 
	 * 		equal parts and recursively call itself on both parts.
	 * 5. 	Then merge the two resulting LL using a merge function and return the head of the List.
	 * 
	 * Time Complexity(order of growth):
	 * 		helper function : O(log k)
	 * 		merge function : O(n)
	 * 
	 * overall time complexity : O(n * log k)
	 * 
	 * Space Complexity:
	 * 		helper function : O(log k)
	 * 		at each level of recursion creates a new stack frame which consume O(log k) space
	 * 
	 * */
	
	public static ListNode mergeKLists(ListNode[] lists) {
		return mergeKListsHelper(lists, 0, lists.length - 1);
	}
	
	public static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
		if(start > end)
			return null;
		if(start == end)
			return lists[start];
		
		int mid = (start + end) / 2;
		ListNode left = mergeKListsHelper(lists, start, mid);
		ListNode right = mergeKListsHelper(lists, mid + 1, end);
		return merge(left, right);
	}
	
	public static ListNode merge(ListNode list1, ListNode list2) {
					
		ListNode dummy = new ListNode();
		ListNode current = dummy;
		ListNode p1 = list1;
		ListNode p2 = list2;
		
		if(p1 == null) {
			return p2;
		}
		if(p2 == null) {
			return p1;
		}
		
		while(p1 != null && p2 != null) {
			if(p1.val <= p2.val) {
				current.next = p1;
				p1 = p1.next;
			}
			else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
			if(p1 != null) {
				current.next = p1;
			}
			if(p2 != null) {
				current.next = p2;
			}
		}
		return dummy.next;
	}
	
	
	/*
	 * PROBLEM 05:
	 * 
	 * Given a linked list, swap every two adjacent and return its head.
	 * You must solve the problem without modifying the lists nodes(i.e only nodes themselves
	 * may be changed)
	 * 
	 * example:
	 * 
	 * 1->2->3->4
	 * 
	 * 2->1->4->3
	 * 
	 * 
	 * */
	
	
	/*
	 * PROBLEM 6 : Convert Binary Number in a Linked List to Integer
	 * 
	 * THIS SOLUTION NEEDS TO BE REFACTORED TO MAKE IT SIMPLE
	 * 
	 * */
	public static int getDecimalValue(ListNode head) {
		ListNode p1;
		p1 = head;
		List<Integer> bins = new ArrayList<>();
		while(p1 != null) {
			bins.add(p1.val);
			p1 = p1.next;
		}
		if(bins.size() == 1 && bins.get(0) == 0) {
			return 0;
		}
		Collections.reverse(bins);
		int dec = 0;
		int pow = 0;
		for(Integer i : bins) {
			if(i == 1) {
				dec = (int) (dec + Math.pow(2, pow));
			}
			pow++;
		}
		return dec;
	}
	
	
	/*
	 * PROBLEM 7 : LL : 876 : MIDDLE OF LL
	 * 
	 * given the head of a singly linked list, return the middle node, if there are two middle
	 * nodes, return the second middle node.
	 * 
	 * */
	public static ListNode middleNode(ListNode head) {
		ListNode p1 = head;
		ListNode p2 = head;
		if(p2.next != null && p2.next.next == null) {
			return p1.next;
		}
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if(p2.next != null && p2.next.next == null) {
				return p1.next;
			}
		}
		return p1;
	}
	
	/*
	 * PROBLEM 8 : LL 206 : REVERSE A LL
	 * 
	 * */
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		ListNode curr = head;
		
		//	p n		h|c
		//  null   	1  ->  2  ->  3  ->  4  ->  5

		//	p 		h|c		n
		//  null <- 1    	2  ->  3  ->  4  ->  5

		//	 		p|h|c	n
		//  null <- 1    	2  ->  3  ->  4  ->  5

		//	 		h|p  	c|n
		//  null <- 1    	2  ->  3  ->  4  ->  5

		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	/**
	 * P9 : LL 160 : Find the intersection node
	 * */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA;
		ListNode inter = new ListNode();
		while(p1.next != null) {
			p1 = p1.next;
			ListNode p2 = headB;
			while(p2.next != null) {
				p2 = p2.next;
				if(p1.val == p2.val) {
					inter = p1;
				}
			}
		}
		return inter;
	}
	
	/**
	 * P10 : LL83 : given a sorted linked list, delete all duplicates
	 * */
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode p = head;
		while(p != null && p.next != null) {
			if(p.val == p.next.val) {
				p.next = p.next.next;
			}
			else 
				p = p.next;
		}
			return head;
	}
	
	/**
	 * P12 : LL83 : given the head of a linked list, return true if it is a palindrome
	 * or false otherwise
	 * 
	 * */
	public static boolean isPalindrome(ListNode head) {
		ListNode current = head;
		List<Integer> list = new ArrayList<>();
		while(current != null) {
			list.add(current.val);
			current = current.next;
		}
		int i = 0;
		int j = list.size() - 1;
		while(i<j) {
			if(!list.get(i).equals(list.get(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	
	/**
	 * P13: LL203 : Given a LL and an integer val, remove all the node equal to val
	 * */
	public static ListNode removeElements(ListNode head, int val) {
		ListNode current = head;
		while(current != null) {
         if(current.val == val){
            current = current.next;
         }
         head = current;
		}
		return head;
	}
   
   /**
      P8 - RE - REVERSE A LL
   */
   public static ListNode reverseLinked(ListNode head){
      ListNode prev = null;
      ListNode next = null;
      ListNode curr = head;
      while(curr!=null){
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }   
      head = prev;
      return head;
   }
	
	public static void main(String[] args) {
   
      //1,2,6,3,4,5,6
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(3);
	// 	ListNode l5 = new ListNode(4);
	// 	ListNode l6 = new ListNode(5);
	// 	ListNode l7 = new ListNode(6);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
	// 	l4.next = l5;
// 		l5.next = l6;
// 	   l6.next = l7;
// 		

      ListNode l = reverseLinked(l1);		
		while(l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}
	}
	
}
