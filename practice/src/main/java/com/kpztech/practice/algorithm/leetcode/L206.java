package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

/**
 * 反转一个单链表。
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class L206 {
	// 迭代
	public ListNode reverseList(ListNode head) {
		ListNode node = head;
		ListNode prev = null;
		// prev = null; node = 1; temp = 2;
		// prev.next = null; prev = 1; node = 2;
		// prev.next = 1; prev = 2; node = 3;
		while (node != null) {
			ListNode temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}
		return prev;
	}


	public ListNode reverseListByDiGui(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// head = 4; head.next = 5; head.next.next = null;
		// head.next.next = 4; head.next = null; head = reverseListByDiGui(5) 5->4
		// head.next.next = 3; head.next = null; head = reverseListByDiGui(4) 5->4->3
		ListNode p = reverseListByDiGui(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

	@Test
	public void test1() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
//		ListNode result = reverseList(l1);
//		while (result != null) {
//			System.out.println(result.val);
//			result = result.next;
//		}
		ListNode result1 = reverseListByDiGui(l1);

		while (result1 != null) {
			System.out.println(result1.val);
			result1 = result1.next;
		}
	}
}
