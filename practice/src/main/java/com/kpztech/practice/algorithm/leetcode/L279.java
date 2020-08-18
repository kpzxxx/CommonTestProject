package com.kpztech.practice.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 */
public class L279 {

	@Test
	public void test() {
		int result = numSquares(13);
		Assert.assertEquals(result, 2);
	}

	public int numSquares(int n) {
		return 0;
	}
}
