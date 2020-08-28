package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class L24 {


  public ListNode swapPairs(ListNode head) {
    // 方便循环，做个假头
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode prevNode = dummy;
    while (head != null && head.next != null) {
      ListNode first = head;
      ListNode second = head.next;

      // 交换节点
      prevNode.next = second;
      first.next = second.next;
      second.next = first;

      // head指针移到第3位
      prevNode = first;
      head = first.next;
    }
    return dummy.next;

  }

  @Test
  public void test() {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    ListNode head = swapPairs(n1);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }

}
