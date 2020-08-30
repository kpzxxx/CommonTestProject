package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class L322 {
	// 自底向上dp
	public int coinChange(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[max];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		// 初始化了amount+1,如果dp[amount]>amount，则无解
		return dp[amount] > amount ? -1 : dp[amount];
	}

	@Test
	public void test() {
		System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
//		System.out.println(coinChange(new int[]{2}, 3));
	}
}
