package com.kpztech.practice.algorithm.huawei;

import java.util.Scanner;

/**
 * m个人分n个月饼，单人分到最多的个数为Max1，单人分到第二多的个数为Max2，要求Max1-Max2<=3,依次类推Max(n)-Max(n+1)<=3，问有多少种分法
 * 如：m=3,n=12,4+4+4，3+4+5，2+4+6，2+5+5，3+3+6，1+4+7 共6种分法，写个输入是m,n输出是分法数量的算法
 * 输入：m n
 * 输出：分法数量
 */
public class Test2 {

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
