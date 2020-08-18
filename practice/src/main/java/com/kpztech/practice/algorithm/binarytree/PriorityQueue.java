package com.kpztech.practice.algorithm.binarytree;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最大优先队列
 * 父=parent,左=parent*2+1,右=parent*2+2
 */
public class PriorityQueue {
	private int[] array;
	private int size;

	public PriorityQueue() {
		array = new int[32];
	}

	@Test
	public void test() throws Exception {
		PriorityQueue p = new PriorityQueue();
		p.enQueue(3).enQueue(5).enQueue(10).enQueue(2).enQueue(7);
		while (!p.isEmpty()) {
			System.out.println("Poll:" + p.deQueue());
		}
	}

	public PriorityQueue enQueue(int key) {
		if (size >= array.length) {
			resize();
		}
		array[size++] = key;
		upAdjust();
		return this;
	}

	public int deQueue() throws Exception {
		if (size <= 0) {
			throw new Exception("The queue is empty!");
		}

		int head = array[0];
		array[0] = array[--size];
		downAdjust();
		return head;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	private void upAdjust() {
		int childIndex = size - 1;
		int parentIndex = (childIndex - 1) >> 1;
		int temp = array[childIndex];
		// 孩子节点大于父节点的值
		while (childIndex > 0 && temp > array[parentIndex]) {
			array[childIndex] = array[parentIndex];
			childIndex = parentIndex;
			parentIndex >>= 1;
		}
		array[childIndex] = temp;
	}

	private void downAdjust() {
		int childIndex = 1;
		int parentIndex = 0;
		int temp = array[parentIndex];
		while (childIndex < size) {
			// 右孩子大于左孩子，定位到右孩子
			if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
				childIndex++;
			}
			// 比2个孩子都大，退出循环
			if (temp >= array[childIndex]) {
				break;
			}
			// 默认和左孩子比
			array[parentIndex] = array[childIndex];
			parentIndex = childIndex;
			childIndex = childIndex << 1 + 1;
		}
		array[parentIndex] = temp;
	}

	private void resize() {
		int newSize = this.size << 1;
		this.array = Arrays.copyOf(this.array, newSize);
	}
}
