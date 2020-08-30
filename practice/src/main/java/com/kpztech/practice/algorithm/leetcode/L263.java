package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

/**
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * <p>
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * <p>
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 */
public class L263 {
	public boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}
		while (num > 1) {
			if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
				return false;
			}
			if (num % 2 == 0) {
				num /= 2;
			}
			if (num % 3 == 0) {
				num /= 3;
			}
			if (num % 5 == 0) {
				num /= 5;
			}
		}
		return true;

	}

	@Test
	public void test() {
		System.out.println(isUgly(-2147483648));
		System.out.println(isUgly(8));
		System.out.println(isUgly(14));
	}
}
