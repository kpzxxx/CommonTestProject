package com.kpztech.practice.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，
 * 数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 * <p>
 * 2020-06-14
 * 注意：不要重复造轮子，直接看答案，做的多了就可以统计规律，变成思维习惯和能力。
 * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 */
@Slf4j
public class BestNumOfArray {
	public static void main(String[] args) {
		int t1 = 10;
		int t2 = 56803;

		int[] a1 = {4, 9, 3};
		int[] a2 = {2, 3, 5};
		int[] a3 = {60864, 25176, 27249, 21296, 20204};

		findBestValue1(a1, t1);
//		findBestValue1(a2, t1);
//		findBestValue1(a3, t2);
	}

	// 耗时太长
	public static int findBestValue(int[] arr, int target) {
		// 思路：理想情况下，则可以从最大值开始，依次减小来遍历
		int result = 0;
		int sumTemp;
		int perfectValue = target / arr.length - 1;
		int sumMin = Integer.MAX_VALUE;
		int targetMin = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		for (int value : arr) {
			if (value > maxValue) {
				maxValue = value;
			}
		}

		for (int i = maxValue; i > perfectValue && i >= 0; i--) {

			int sum1 = 0;
			for (int value : arr) {
				sum1 += Math.min(value, i);
			}
			sumTemp = Math.abs(sum1 - target);
			if (sumTemp <= sumMin) {
				sumMin = sumTemp;
				targetMin = sum1;
				result = i;
			}
		}
		log.info("Result={}, Target={}, Sum={}", result, target, targetMin);
		return result;
	}

	public static int findBestValue1(int[] arr, int target) {
		// 思路：Map<Integer, Integer> = 元素值，元素在数组中的个数
		int maxValue = Integer.MIN_VALUE;
		int perfectValue = target / arr.length - 1;
		int targetMin = 0;
		Map<Integer, Integer> map = new ConcurrentHashMap<>(arr.length);
		for (int i : arr) {
			if (i > maxValue) {
				maxValue = i;
			}
			if (map.get(i) != null) {
				int count = map.get(i);
				map.put(i, count + 1);
			} else {
				map.put(i, 1);
			}
			targetMin += i;
		}

		int result = maxValue;
		int targetTemp;
		for (int i = maxValue - 1; i > perfectValue && i >= 0; i--) {
			targetTemp = targetMin - target;
			if (map.containsKey(i) && map.get(i) != null) {
				targetMin -= map.get(i) + 1;
			} else {
				targetMin--;
			}
			int targetAbs = targetMin - target;
			if (targetAbs <= 0) {
				if (-targetAbs <= targetTemp) {
					result = i;
				} else {
					result = i + 1;
				}
				break;

			}
		}
		log.info("Result={}, Target={}, Sum={}", result, target, targetMin);
		return result;
	}
}
