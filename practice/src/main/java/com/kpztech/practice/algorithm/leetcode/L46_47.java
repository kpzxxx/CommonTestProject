package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。 给定一个 可以重复 数字的序列，返回其所有可能的全排列。
 *
 * 输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/permutations 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L46_47 {

  // 回溯+递归
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> output = new ArrayList<>();
    Arrays.stream(nums).forEach(output::add);
    backtrack(nums.length, output, result, 0);
    return result;
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    return null;
  }

  private void backtrack(int n, List<Integer> output, List<List<Integer>> result, int first) {
    if (first == n) {
      result.add(new ArrayList<>(output));
    }

    for (int i = first; i < n; i++) {
      Collections.swap(output, first, i);
      backtrack(n, output, result, first + 1);
      Collections.swap(output, first, i);
    }
  }

  @Test
  public void test() {
    int[] input = {1, 2, 3};
    List<List<Integer>> result = permute(input);
    System.out.println(result);
  }

}
