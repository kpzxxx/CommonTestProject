package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L209 {

  public int minSubArrayLen(int s, int[] nums) {
    List<Integer> list = new LinkedList<>();
    int count = nums.length;
    int sum = 0;
    int allSum = 0;
    for (int num : nums) {
      allSum += num;
      if (sum < s) {
        sum += num;
        list.add(num);
      }
      int index = 0;
      while (sum >= s) {
        int temp = list.get(index);
        count = Math.min(count, list.size());
        list.remove(index);
        sum -= temp;
      }
    }
    if (allSum < s) {
      return 0;
    }
    return count;
  }

  public static int minSubArrayLen1(int s, int[] nums) {
    int low = 0;
    int high = 0;
    int min = Integer.MAX_VALUE;
    int sum = 0;
    while (high < nums.length) {
      sum += nums[high++];
      while (sum >= s) {
        min = Math.min(min, high - low);
        sum -= nums[low++];
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  @Test
  public void test() {
    int[] nums = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
    int s = 15;
    System.out.println(minSubArrayLen(s, nums));
  }

}
