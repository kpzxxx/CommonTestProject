package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

/**
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 */
public class L264 {
	public int nthUglyNumber(int n) {
		int[] uglys = new int[1690];
		uglys[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		for (int i = 1; i < 1690; i++) {
			int ugly = Math.min(uglys[i2] * 2, Math.min(uglys[i3] * 3, uglys[i5] * 5));
			uglys[i] = ugly;

			if (uglys[i2] * 2 == ugly) {
				i2++;
			}
			if (uglys[i3] * 3 == ugly) {
				i3++;
			}
			if (uglys[i5] * 5 == ugly) {
				i5++;
			}
		}


		return uglys[n - 1];

	}

	@Test
	public void test() {
		System.out.println(nthUglyNumber(10));
	}
}
