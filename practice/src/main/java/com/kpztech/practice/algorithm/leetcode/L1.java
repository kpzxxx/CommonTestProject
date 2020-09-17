package com.kpztech.practice.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 */
public class L1 {

  // 暴力法
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }

    return null;
  }

  // Map中介法
  public int[] twoSum1(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int to = target - nums[i];
      if (map.containsKey(to)) {
        return new int[]{map.get(to), i};
      }
      map.put(nums[i], i);
    }

    return null;
  }

  @Test
  public void test() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result = twoSum1(nums, target);
    System.out.println(JSON.toJSONString(result));
  }
}
