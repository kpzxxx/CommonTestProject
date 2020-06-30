package com.kpztech.practice.base;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

public class RandomTest {

  public static void main(String[] args) {
//    test1();
//    lottery();
    for (int i=0; i<10; i++){
      knuthShuffle();
    }
  }

  private static void test1() {
    int bound = 1000;
    Random random1 = new Random(0);
    Random random2 = new Random(0);
    for (int i = 0; i < 100; i++) {
      System.out.println(random1.nextInt(bound) + "-" + random2.nextInt(bound));
    }
  }

  /**
   * 杭州市2020年6月份小客车增量指标摇号结束。本月以摇号方式向单位和个人配置增量指标5333个，其中个人指标4693个，单位指标640个。参与本期摇号的个人有效编码数868183个，单位有效编码数21729个。
   */
  private static void lottery() {
    int bound = 868183;
//    long seed = 987436;
    Random random = new Random();
    int winner = 4693;
    for (int i = 0; i < winner; i++) {
      System.out.println(random.nextInt(bound));
    }
  }

  private static void knuthShuffle() {
    List<Integer> list = Lists.newArrayList();
    Random random = new Random();
    for (int i = 1; i <= 10; i++) {
      list.add(i);
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      // 随机从0-i间选一个数
      int selection = random.nextInt(i + 1);

      // 交换selection和i的位置
      int temp = list.get(i);
      list.set(i, list.get(selection));
      list.set(selection, temp);
    }

    System.out.println(JSON.toJSONString(list));


  }

}
