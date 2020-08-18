package com.kpztech.practice.algorithm.binarytree;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lombok.Data;

@Data
public class TreeNode {

	private int data;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}

	public TreeNode() {
	}

	public List<Integer> prePrint(TreeNode root) {
		List<Integer> list = Lists.newArrayList();
		return prePrint(root, list);
	}

	private List<Integer> prePrint(TreeNode node, List<Integer> printList) {
		printList.add(data);
		if (left != null) {
			prePrint(node.left, printList);
		}
		if (right != null) {
			prePrint(node.right, printList);
		}
		return printList;
	}

	private List<Integer> midPrint(TreeNode node, List<Integer> printList) {
		if (left != null) {
			midPrint(node.left, printList);
		}
		printList.add(data);
		if (right != null) {
			midPrint(node.right, printList);
		}
		return printList;
	}

	private List<Integer> backPrint(TreeNode node, List<Integer> printList) {
		if (left != null) {
			backPrint(node.left, printList);
		}
		if (right != null) {
			backPrint(node.right, printList);
		}
		printList.add(data);
		return printList;
	}

	private List<Integer> layerPrint(TreeNode node, List<Integer> printList) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		while (!queue.isEmpty()){
			TreeNode treeNode = queue.poll();
			printList.add(treeNode.data);
			if(treeNode.left != null){
				queue.offer(treeNode.left);
			}
			if(treeNode.right != null){
				queue.offer(treeNode.right);
			}
		}

		return printList;
	}

}
