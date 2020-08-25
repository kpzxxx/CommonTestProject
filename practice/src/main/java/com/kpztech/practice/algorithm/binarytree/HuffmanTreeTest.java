package com.kpztech.practice.algorithm.binarytree;

import java.util.PriorityQueue;
import java.util.Queue;

import lombok.Data;


public class HuffmanTreeTest {

  public static void main(String[] args) {
    int[] weights = {2, 3, 7, 9, 18, 25};
    char[] chars = {'A', 'B', 'C', 'D', 'E', 'F'};
    HuffmanTree huffmanTree = new HuffmanTree();
    huffmanTree.createHuffman(weights);
    huffmanTree.encode(huffmanTree.root, "");
//    huffmanTree.print(huffmanTree.root);

    for (int i = 0; i < chars.length; i++) {
      System.out.println(chars[i] + ":" + huffmanTree.convertHuffmanCode(i));
    }
  }


  private static class HuffmanTree {

    private Node root;
    private Node[] nodes;

    void createHuffman(int[] weights) {
      Queue<Node> nodeQueue = new PriorityQueue<>();
      nodes = new Node[weights.length];

      for (int i = 0; i < weights.length; i++) {
        nodes[i] = new Node(weights[i]);
        nodeQueue.add(nodes[i]);
      }

      while (nodeQueue.size() > 1) {
        Node left = nodeQueue.poll();
        Node right = nodeQueue.poll();

        Node parent = new Node(left.getWeight() + right.getWeight(), left, right);
        nodeQueue.add(parent);
      }
      root = nodeQueue.poll();

    }

    public String convertHuffmanCode(int index) {
      return nodes[index].code;
    }

    public void encode(Node node, String code) {
      if (node == null) {
        return;
      }
      node.code = code;
      encode(node.left, node.code + "0");
      encode(node.right, node.code + "1");
    }

    void print(Node head) {
      if (head == null) {
        return;
      }
      System.out.println(head.getWeight());
      print(head.getLeft());
      print(head.getRight());
    }
  }


  @Data
  public static class Node implements Comparable<Node> {

    private String code;
    private int weight;
    private Node left;
    private Node right;

    Node(int weight) {
      this.weight = weight;
    }

    Node(int weight, Node left, Node right) {
      this.weight = weight;
      this.left = left;
      this.right = right;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.getWeight(), o.getWeight());
    }
  }

}
