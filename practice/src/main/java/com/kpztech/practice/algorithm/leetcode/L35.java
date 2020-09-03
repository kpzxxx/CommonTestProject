package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。 输入: [1,3,5,6], 5 输出: 2 输入: [1,3,5,6], 2 输出: 1 输入: [1,3,5,6], 7 输出: 4 输入: [1,3,5,6], 0 输出: 0
 */
public class L35 {

  // 二分查找
  public int searchInsert(int[] nums, int target) {
    int len = nums.length;
    if (len == 0) {
      return 0;
    }

    if (nums[len - 1] < target) {
      return len;
    }

    int left = 0;
    int right = len - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if(nums[mid] < target){
        left = mid + 1;
      }else {
        right = mid;
      }
    }
    return left;
  }

  @Test
  public void test() {
    int[] n1 = {1, 3, 5, 6};
    int t1 = 5;
    int t2 = 2;
    int t3 = 7;
    int t4 = 0;
    System.out.println(searchInsert(n1, t1));
    System.out.println(searchInsert(n1, t2));
    System.out.println(searchInsert(n1, t3));
    System.out.println(searchInsert(n1, t4));
  }

}
