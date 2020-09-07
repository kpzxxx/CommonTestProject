package com.kpztech.practice.base.java;


import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class OptionTest {

  @Test
  public void test1() {
    List<String> numbers = ImmutableList.of("ONE", "TWO", "THREE");
    String four1 = numbers.stream().filter(n -> n.equals("FOUR")).findAny().orElseGet(this::supplier);
    String four2 = numbers.stream().filter(n -> n.equals("FOUR")).findAny().orElse("FOUR");

    System.out.println(four1);
    System.out.println(four2);

    String four3 = numbers.stream().filter(n -> n.equals("FOUR")).findAny().orElseThrow(
        () -> new RuntimeException("Error!!!"));
    System.out.println(four3);


  }

  private String supplier() {
    return "SUPPLY";
  }

}
