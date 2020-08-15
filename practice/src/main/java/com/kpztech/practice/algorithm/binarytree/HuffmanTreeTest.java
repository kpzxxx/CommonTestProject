package com.kpztech.practice.algorithm.binarytree;

import java.util.PriorityQueue;
import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Data;


public class HuffmanTreeTest {

  public static void main(String[] args) {
    int[] weights = {2,3,7,9,18,25};
    HuffmanTree huffmanTree = new HuffmanTree();
    huffmanTree.createHuffman(weights);
    huffmanTree.print(huffmanTree.root);
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

      while (nodeQueue.size() > 1){
        Node left = nodeQueue.poll();
        Node right = nodeQueue.poll();

        Node parent = new Node(left.getValue() + right.getValue(), left, right);
        nodeQueue.add(parent);
      }
      root = nodeQueue.poll();

    }

    void print(Node head){
      if(head == null){
        return;
      }
      System.out.println(head.getValue());
      print(head.getLeft());
      print(head.getRight());
    }
  }



  @Data
  @AllArgsConstructor
  public static class Node implements Comparable<Node>{

    private int value;
    private Node left;
    private Node right;

    Node(int value) {
      this.value = value;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.getValue(), o.getValue());
    }
  }

}
