package com.kpztech.practice.algorithm.huawei;

import java.util.Scanner;

public class Main2 {

  // 动态规划处理，时间不够未完成。
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String s1 = scanner.nextLine();

      String[] split = s1.split(" ");
      int m = Integer.parseInt(split[0]);
      int n = Integer.parseInt(split[1]);
      int devideNum = 1;

      int ave = n / m;

      int[] mn = new int[m];
      for (int i = 0; i < m; i++) {
        mn[i] = ave;
      }

    }
  }

  private int dp(int max1, int max2){
    // ...
    return dp(max1, max2);
  }

}
