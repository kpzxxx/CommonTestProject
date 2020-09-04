package com.kpztech.practice.algorithm.sort;

import org.junit.Test;

import lombok.Data;

/**
 * 有一个无序整形数组，如何求出该数组排序后的任意两个相邻元素的最大差值？要求时间和空间复杂度尽可能低
 */
public class BucketSort {

  public int getMaxSortedDistance(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // 找到最大最小值
    int max = nums[0];
    int min = nums[0];
    for (int num : nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    int d = max - min;
    if (d == 0) {
      return 0;
    }
    // 切分桶，填充最大最小值
    int bucketNum = nums.length;
    Bucket[] buckets = new Bucket[bucketNum];
    for (int num : nums) {
      int index = (num - min) * (bucketNum - 1) / d;
      if (buckets[index] == null) {
        buckets[index] = new Bucket();
      }
      if (buckets[index].getMin() == null || buckets[index].getMin() > num) {
        buckets[index].setMin(num);
      }
      if (buckets[index].getMax() == null || buckets[index].getMax() < num) {
        buckets[index].setMax(num);
      }
    }

    // 遍历桶，找到最大差值
    int maxDistance = 0;
    int leftMax = buckets[0].getMax();
    for (Bucket bucket : buckets) {
      if (bucket != null && bucket.getMin() != null && (bucket.getMin() - leftMax) > maxDistance) {
        maxDistance = bucket.getMin() - leftMax;
        leftMax = bucket.getMax();
      }
    }
    return maxDistance;

  }

  @Data
  private static class Bucket {

    private Integer max;
    private Integer min;
  }

  @Test
  public void test() {
    int[] nums = {2, 6, 3, 4, 5, 10, 9};
    System.out.println(getMaxSortedDistance(nums));
  }

}
