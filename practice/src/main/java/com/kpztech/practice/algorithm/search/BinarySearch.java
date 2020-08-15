package com.kpztech.practice.algorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {1, 4, 8, 16, 45, 48, 78};

		for (int value : arr) {
			System.out.println(binarySearch(arr, value));
		}
		System.out.println(binarySearch(arr, 0));
		System.out.println(binarySearch(arr, 20));
		System.out.println(binarySearch(arr, 100));

	}

	private static int binarySearch(int[] arr, int target) {
		return binarySearch(arr, target, 0, arr.length - 1);
	}

	private static int binarySearch(int[] arr, int target, int low, int high) {
		int middle = (low + high) / 2;
		if (target < arr[low] || target > arr[high] || low == middle) {
			return -1;
		} else if (target == arr[low]) {
			return low;
		} else if (target == arr[high]) {
			return high;
		}

		if (target < arr[middle]) {
			return binarySearch(arr, target, low, middle);
		} else if (target > arr[middle]) {
			return binarySearch(arr, target, middle, high);
		} else {
			return middle;
		}

	}

}
