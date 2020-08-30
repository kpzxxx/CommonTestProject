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
		int result = numSquares1(13);
		Assert.assertEquals(result, 2);
	}

	@Test
	public void test1(){
		System.out.println(numSquares1(130));
	}

	// 数学公式法：拉格朗日四平方和
	public int numSquares(int n) {
		if (isSquare(n)) {
			return 1;
		}
		while (n % 4 == 0) {
			n /= 4;
		}
		if (n % 8 == 7) {
			return 4;
		}
		for (int i = 1; i * i <= n; i++) {
			if (isSquare(n - i * i)) {
				return 2;
			}
		}
		return 3;
	}

	// dp
	public int numSquares1(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; i - j * j >= 0; j++) {
				min = Math.min(dp[i - j * j] + 1, min);
			}
			dp[i] = min;
		}
		return dp[n];
	}

	boolean isSquare(int n) {
		int sq = (int) Math.sqrt(n);
		return n == sq * sq;
	}
}
