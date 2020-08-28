package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L15 {

  // 排序+双指针
  public List<List<Integer>> threeSum(int[] nums) {
    // 排序
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    for (int first = 0; first < n; first++) {

      // 相同的数没必要继续循环
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }

      int third = n - 1;
      int target = -nums[first];

      for (int second = first + 1; second < n; second++) {

        // 相同的数没必要继续循环
        if (second > first + 1 && nums[second] == nums[second - 1]) {
          continue;
        }

        // 指针移动
        while (second < third && nums[second] + nums[third] > target) {
          third--;
        }

        // 指针重合，退出循环
        if (second == third) {
          break;
        }
        if (nums[second] + nums[third] == target) {
          List<Integer> list = new ArrayList<>();
          list.add(nums[first]);
          list.add(nums[second]);
          list.add(nums[third]);
          result.add(list);
        }

      }

    }

    return result;
  }

  @Test
  public void test() {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> result = threeSum(nums);
    System.out.println(result);
  }

}
