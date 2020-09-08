package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 写入数据 put(key, value) -
 * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/lru-cache 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L146 {

  @Test
  public void test() {
    LRUCache cache = new LRUCache(2 /* 缓存容量 */);

    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));     // 返回  1

    cache.put(3, 3);    // 该操作会使得关键字 2 作废
    System.out.println(cache.get(2));       // 返回 -1 (未找到)

    cache.put(4, 4);    // 该操作会使得关键字 1 作废
    System.out.println(cache.get(1));       // 返回 -1 (未找到)

    System.out.println(cache.get(3));       // 返回  3
    System.out.println(cache.get(4));

  }


  public static class LRUCache {

    private int size;
    private int capacity;
    
    // 用头尾的虚节点保证一致性
    private DLinkedNode head, tail;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
      this.size = 0;
      this.capacity = capacity;
      head = new DLinkedNode();
      tail = new DLinkedNode();
      head.next = tail;
      tail.prev = head;
    }

    // HashMap使get操作有O(1)的复杂度
    public int get(int key) {
      DLinkedNode node = cache.get(key);
      if (node == null) {
        return -1;
      }

      moveToHead(node);

      return node.value;
    }

    public void put(int key, int value) {
      DLinkedNode node = cache.get(key);
      if (node == null) {
        DLinkedNode newNode = new DLinkedNode(key, value);
        cache.put(key, newNode);
        addToHead(newNode);
        ++size;
        // 超过size，淘汰tail
        if (size > capacity) {
          DLinkedNode tail = removeTail();
          cache.remove(tail.key);
          --size;
        }

      } else {
        node.value = value;
        moveToHead(node);
      }

    }

    private void moveToHead(DLinkedNode node) {
      removeNode(node);
      addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
      node.prev = head;
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
    }

    private void removeNode(DLinkedNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private DLinkedNode removeTail() {
      DLinkedNode res = tail.prev;
      removeNode(res);
      return res;
    }

    static class DLinkedNode {

      int key;
      int value;
      DLinkedNode prev;
      DLinkedNode next;

      public DLinkedNode() {

      }

      public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }

}
