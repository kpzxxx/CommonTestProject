package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 输入: [3,4,5,1,2] 输出: 1
 *
 * 输入: [4,5,6,7,0,1,2] 输出: 0
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L153 {

  public int findMin(int[] nums) {
    int len = nums.length;

    if (len == 0) {
      return 0;
    }

    int left = 0;
    int right = len - 1;

    // 未翻转
    if (nums[left] <= nums[right]) {
      return nums[left];
    }

    // 如果有翻转，
    while (left < right) {
      int mid = left + (right - left + 1) / 2;
      // 翻转点在二分点右侧
      if (nums[mid] > nums[left]) {
        left = mid;
      } else {
        // 翻转点在二分点左侧
        right = mid - 1;
      }
    }

    // left +1是翻转头，left是翻转尾
    return nums[left + 1];

  }

  @Test
  public void test() {
    int[] nums1 = {3, 4, 5, 1, 2};
    int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(findMin(nums1));
    System.out.println(findMin(nums2));
  }
}
