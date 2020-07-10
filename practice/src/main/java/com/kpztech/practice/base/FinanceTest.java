package com.kpztech.practice.base;

import java.math.BigDecimal;

public class FinanceTest {

  public static void main(String[] args) {
    int times = 12;
    double inc = 10000;
    double rate = 1.01;
    int years = 20;

    System.out.println(inc);
    for (int j = 1; j <= years; j++) {
      double result = inc;
      for (int i = 0; i < times * j; i++) {
        result = new BigDecimal(result).multiply(new BigDecimal(rate)).setScale(2, BigDecimal.ROUND_HALF_UP).add(
            new BigDecimal(inc)).doubleValue();
        if (times * j == i + 1) {
          System.out.println("Y" + j + ":" + result);
        }
      }
    }

  }

}
