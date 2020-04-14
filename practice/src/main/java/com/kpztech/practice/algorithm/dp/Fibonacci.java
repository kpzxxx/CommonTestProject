package com.kpztech.practice.algorithm.dp;

public class Fibonacci {

  public static void main(String[] args) {
    for (int i = 1; i <= 20; i++) {
      System.out.println(generate(i));

    }
  }

  private static long generate(int n) {
    int[] dp = {1, 1};
    if (n <= 0) {
      return 0;
    }

    int in;
    for (int i = 3; i <= n; i++) {
      in = dp[0];

      dp[0] = dp[1];
      dp[1] += in;

    }
    return dp[1];

  }

}
