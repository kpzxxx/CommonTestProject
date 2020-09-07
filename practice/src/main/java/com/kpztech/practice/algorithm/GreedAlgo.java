package com.kpztech.practice.algorithm;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 给出一个整数，从该整数中去掉k个数字，要求剩下的数字形成的新整数尽可能小，输出最小的数字。 如： 1593212 k=3 -> 1212
 */
public class GreedAlgo {

  public String removeDigits(String num, int k) {
    if (k <= 0 || StringUtils.isBlank(num)) {
      return num;
    }

    char[] chars = num.toCharArray();

    



    return null;


  }

  @Test
  public void test() {
    System.out.println(removeDigits("1593212", 3));
    System.out.println(removeDigits("30200", 1));
    System.out.println(removeDigits("10", 2));
    System.out.println(removeDigits("541270936", 3));
  }

}
