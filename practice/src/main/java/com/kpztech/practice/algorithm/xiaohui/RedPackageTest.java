package com.kpztech.practice.algorithm.xiaohui;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 红包随机算法：二倍均值法
 */
public class RedPackageTest {

  // num-红包个数 moneyNum-总金额
  public static List<Long> randomMoney(int num, long moneyNum) {
    List<Long> result = Lists.newArrayList();

    if (num <= 0 || moneyNum <= 0) {
      return result;
    }

    // 随机范围：1->剩余钱/人数*2；即人均剩余钱数的2倍。
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
