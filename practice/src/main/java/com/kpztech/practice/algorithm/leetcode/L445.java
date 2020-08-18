package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L445 {

	@Test
	public void test() {
		ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		ListNode l = addTwoNumbers(l1, l2);
		while (l != null) {
			System.out.print(l.val);
			l = l.next;
		}
	}

	// 用栈
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 入栈
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}

		ListNode result = null;
		int carry = 0;
		while (!stack1.empty() || !stack2.empty() || carry > 0) {
			int a = stack1.empty() ? 0 : stack1.pop();
			int b = stack2.empty() ? 0 : stack2.pop();
			int cur = a + b + carry;
			carry = cur / 10;
			cur %= 10;
			if (result == null) {
				result = new ListNode(cur);
			} else {
				result = new ListNode(cur, result);
			}
		}
		return result;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		ListNode(int x, ListNode next) {
			val = x;
			this.next = next;
		}
	}


}