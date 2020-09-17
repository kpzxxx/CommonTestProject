package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 */
public class L2 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode l = null;
    boolean carry = false;
    int value;
    while (l1 != null || l2 != null || carry) {
      if(l1 == null && l2 == null){
        value = 0;
      }else {
        if (l1 == null) {
          value = l2.val;
        } else if (l2 == null) {
          value = l1.val;
        } else {
          value = l1.val + l2.val;
        }
      }

      if (carry) {
        value += 1;
      }
      if (head == null) {
        head = new ListNode(value % 10);
        l = head;
      } else {
        l.next = new ListNode(value % 10);
        l = l.next;
      }

      carry = value >= 10;

      if(l1 != null){
        l1 = l1.next;
      }
      if(l2 !=null){
        l2 = l2.next;
      }

    }
    return head;

  }


  @Test
  public void test() {
    ListNode l1_1 = new ListNode(2);
    ListNode l1_2 = new ListNode(4);
    l1_1.next = l1_2;
    ListNode l1_3 = new ListNode(3);
    l1_2.next = l1_3;

    ListNode l2_1 = new ListNode(5);
    ListNode l2_2 = new ListNode(6);
    l2_1.next = l2_2;
    ListNode l2_3 = new ListNode(4);
    l2_2.next = l2_3;
    ListNode listNode = addTwoNumbers(l1_1, l2_1);
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }
}
