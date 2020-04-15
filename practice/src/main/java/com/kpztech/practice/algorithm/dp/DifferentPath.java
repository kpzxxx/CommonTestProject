package com.kpztech.practice.algorithm.dp;

import lombok.extern.slf4j.Slf4j;

/**
 * m*n 网格，一次只能向下或向右移动一步，有多少种走法？
 */
@Slf4j
public class DifferentPath {

  public static void main(String[] args) {
    int m = 3;
    int n = 3;
    System.out.println(dp1(m, n));

  }

  private static int dp1(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }

        log.info("dp[{}][{}]={}", i, j, dp[i][j]);
      }
    }

    return dp[m - 1][n - 1];
  }

  // 怎么简化到用1维数组去处理？
  private static int dp2(int m, int n) {
    int[] dp = {1, 1};
    return 0;
  }

}
