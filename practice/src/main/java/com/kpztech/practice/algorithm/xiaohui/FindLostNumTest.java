package com.kpztech.practice.algorithm.xiaohui;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 无序数组里有若干个整数，范围1~100，有98个数出现了偶数次，2个数出现了奇数次，找出那2个数。
 */
public class FindLostNumTest {
	public int[] findLostNum(int[] array) {

		int[] result = new int[2];

		// 异或运算，找到2个二进制[1]位
		int r1 = 0;
		for (int value : array) {
			r1 ^= value;
		}

		if (r1 == 0) {
			return null;
		}

		// 找到分割的二进制[1]位
		int separator = 1;
		while ((separator & r1) == 0) {
			separator <<= 1;
		}

		// 分组异或，分别找到这2个数
		for (int value : array) {
			if (0 == (value & separator)) {
				result[0] ^= value;
			} else {
				result[1] ^= value;
			}
		}
		return result;
	}

	@Test
	public void test() {
		int[] array = {4, 1, 2, 2, 5, 1, 4, 3};
		int[] result = findLostNum(array);
		System.out.println(JSON.toJSON(result));
	}
}
