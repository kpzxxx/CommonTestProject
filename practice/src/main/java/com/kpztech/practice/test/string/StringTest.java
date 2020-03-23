package com.kpztech.practice.test.string;

import org.apache.commons.lang3.RandomStringUtils;

public class StringTest {

  public static void main(String[] args) {
    for(int i=1; i<11; i++){
      System.out.println(randomStr(i) + "-" + randomStr(i, true));
    }
  }

  public static String randomStr(int length, boolean includeNumeric) {
    if (includeNumeric) {
      return RandomStringUtils.randomAlphanumeric(length);
    } else {
      return RandomStringUtils.randomAlphabetic(length);
    }
  }

  public static String randomStr(int length) {
    return randomStr(length, false);
  }

}
