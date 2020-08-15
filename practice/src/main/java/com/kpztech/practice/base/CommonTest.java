package com.kpztech.practice.base;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import org.junit.Test;

import java.math.BigDecimal;

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

//    System.out.println(0x5DEECE66DL);
//      int i2 = random2.nextInt(868183);
//      System.out.println(i2);

    System.out.println(Long.MAX_VALUE);
    System.out.println(Integer.MAX_VALUE);


  }

  public static Long calculateTotalPrice(Long num, Long price) {
    return new BigDecimal(num).divide(new BigDecimal(1000), 3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(price))
                              .longValue();
  }

  public static Long calculateTotalPrice1(Long num, Long price) {
    return new BigDecimal(num).divide(new BigDecimal(1000), 0, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(price))
                              .longValue();
  }


  @Test
  public void test(){
    Table<Long, Long, String> table = HashBasedTable.create();

    table.put(1L,1L,"A");
    System.out.println(JSON.toJSONString(table));
  }




}
