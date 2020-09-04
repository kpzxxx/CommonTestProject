package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 输入：[1,2,5,9,5,9,5,5,5] 输出：5
 *
 * 输入：[3,2] 输出：-1
 *
 * 输入：[2,2,1,1,1,2,2] 输出：2
 */
public class L1753 {

  // Map存，max刷新
  public int majorityElement(int[] nums) {
    if (nums == null) {
      return -1;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int maxValue = nums[0];
    for (int num : nums) {
      map.merge(num, 1, (o, n) -> o + n);
      if (map.get(num) > max) {
        maxValue = num;
        max = map.get(num);
      }
    }

    return max > nums.length / 2 ? maxValue : -1;

  }

  @Test
  public void test() {
    int[] nums1 = {1, 2, 5, 9, 5, 9, 5, 5, 5};
    System.out.println(majorityElement(nums1));

    int[] nums2 = {3, 2};
    System.out.println(majorityElement(nums2));

    int[] nums3 = {2, 2, 1, 1, 1, 2, 2};
    System.out.println(majorityElement(nums3));
  }

}
