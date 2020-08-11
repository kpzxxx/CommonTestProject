package com.kpztech.practice.algorithm;

/**
 * 判断链表有环
 */
public class ChainOnLinkedTest {
	public static void main(String[] args) {
		Node n1 = new Node(5);
		Node n2 = new Node(3);
		Node n3 = new Node(7);
		Node n4 = new Node(2);
		Node n5 = new Node(6);
		Node n6 = new Node(8);
		Node n7 = new Node(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n4;
		System.out.println(isCycle(n1));
	}

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	// 双指针追及问题。
	private static boolean isCycle(Node head) {
		boolean isCycle = false;
		Node p1 = head;
		Node p2 = head;
		boolean firstMet = true;
		int cycleLength = 0;
		// 计算环长
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				isCycle = true;
				if (firstMet) {
					firstMet = false;
				} else {
					break;
				}
			}
			if (!firstMet) {
				cycleLength++;
			}
		}
		System.out.println("环长：" + cycleLength);

		// 计算入环点
		boolean isCalculate = false;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			if (isCalculate) {
				p2 = p2.next;
			} else {
				p2 = p2.next.next;
			}
			if (p1 == p2) {
				p2 = head;
				if (isCalculate) {
					System.out.println("入环点：" + p1.data);
					break;
				} else {
					isCalculate = true;
				}
			}
		}
		return isCycle;
	}
}
