package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 */
public class L33 {

  public int search(int[] nums, int target) {
    int len = nums.length;
    if (len == 0) {
      return -1;
    }

    int left = 0;
    int right = len - 1;

    while (left < right) {
      int mid = left + (right - left + 1) / 2;
      if (nums[mid] < nums[right]){
        if(nums[mid] <= target && target <= nums[right]){
          left = mid;
        }else {
          right = mid - 1;
        }
      }else {
        if(nums[left] <= target && target <= nums[mid - 1]){
          right = mid - 1;
        }else {
          left = mid;
        }
      }
    }
    if(nums[left] == target){
      return left;
    }
    return -1;
  }

  @Test
  public void test() {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(search(nums, 0));
    System.out.println(search(nums, 3));
  }
}
