package com.kpztech.practice.algorithm.binarytree;

import com.google.common.collect.Lists;

import java.util.List;

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

}
