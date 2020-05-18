package com.kpztech.practice.base;

import java.math.BigDecimal;

public class CommonTest {

  public static void main(String[] args) {
    long num = 5400L;
    long n1 = calculateTotalPrice(5400L,26000000L);
    System.out.println(new BigDecimal(num).divide(new BigDecimal(1000), 3, BigDecimal.ROUND_HALF_UP));
    long n2 = calculateTotalPrice(5400L,34800000L);
    long sum =  n1 + n2;
    System.out.println(sum);
  }

  public static Long calculateTotalPrice(Long num, Long price) {
    return new BigDecimal(num).divide(new BigDecimal(1000), 3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(price))
                              .longValue();
  }

  public static Long calculateTotalPrice1(Long num, Long price) {
    return new BigDecimal(num).divide(new BigDecimal(1000), 0, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(price))
                              .longValue();
  }

}
