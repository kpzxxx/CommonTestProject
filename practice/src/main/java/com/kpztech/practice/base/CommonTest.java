package com.kpztech.practice.base;

import java.math.BigDecimal;
import java.util.Random;

public class CommonTest {

  public static void main(String[] args) {
//    long num = 5400L;
//    long n1 = calculateTotalPrice(5400L,26000000L);
//    System.out.println(new BigDecimal(num).divide(new BigDecimal(1000), 3, BigDecimal.ROUND_HALF_UP));
//    long n2 = calculateTotalPrice(5400L,34800000L);
//    long sum =  n1 + n2;
//    System.out.println(sum);
//
//    ExecutorService executor = Executors.newFixedThreadPool(3);
//
//    System.currentTimeMillis();

//    System.out.println(Integer.toBinaryString(7307));
//    System.out.println(Integer.toBinaryString(-117));
//    System.out.println(0b00011100);
//    System.out.println(0b11111111111111111111111110001011);

    Random random1 = new Random();
    random1.setSeed(0);
    Random random2 = new Random();
    random2.setSeed(0);
    for(int i=0;i<100;i++){
      int i1 = random1.nextInt(868183);
      System.out.print(i1 + " - ");
//      int i2 = random2.nextInt(868183);
//      System.out.println(i2);

    }

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
