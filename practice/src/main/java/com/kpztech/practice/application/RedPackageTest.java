package com.kpztech.practice.application;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RedPackageTest {

  public static List<Long> randomMoney(int num, long moneyNum) {
    List<Long> result = Lists.newArrayList();

    if (num <= 0 || moneyNum <= 0) {
      return result;
    }

    for (int i = num; i >= 2; i--) {
      long x = (moneyNum << 1) / i;
      long random = ThreadLocalRandom.current().nextLong(1, x);
      result.add(random);
      moneyNum -= random;


    }
    result.add(moneyNum);
    return result;

  }

  @Test
  public void test1() {
    int num = 10;
    long money = 100;
    List<Long> result = randomMoney(num, money);
    System.out.println(result);
  }

  @Test
  public void test2() {
    int num = 2;
    long money = 200;
    for (int i = 0; i < 20; i++) {
      List<Long> result = randomMoney(num, money);
      System.out.println(result);
    }

  }


}
