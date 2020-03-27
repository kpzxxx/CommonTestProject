package com.kpztech.practice.test.test3;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * 写一个方法,入参为自然数n  (n > 0)，返回一个自然数数组，数组长度为n，元素为[1,n]之间，且每个元素不重复，数组中各元素顺序要求随机；
 */
public class Test3 {

  public static void main(String[] args) {
    System.out.println(JSON.toJSONString(test3(1)));
    System.out.println(JSON.toJSONString(test3(10)));
    System.out.println(JSON.toJSONString(test3(50)));
    System.out.println(JSON.toJSONString(test3(100)));
  }

  private static int[] test3(int n) {
    int[] array = new int[n];
    Random random = new Random();
    List<Integer> list = Lists.newArrayList(n);
    // 生成数字池
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }

    // 每次生成随机数为数字池的index，生成后数字池移除，下一次生成随机数的范围减1
    for (int i = 1; i <= n; i++) {
      int index = random.nextInt(n - i + 1);
      array[i - 1] = list.get(index);
      list.remove(index);
    }
    return array;


  }
}
