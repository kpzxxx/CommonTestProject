package com.kpztech.practice;

import com.kpztech.practice.util.Calculator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("😊")
public class CommonTests {

  private final Calculator calculator = new Calculator();

  @Test
  void addition(){
    assertEquals(2, calculator.add(1,1));
  }

  @Test
  void failingTest(){
    fail("Fail test!");
  }

  @Test
  @Disabled("For demonstration purposes")
  void skippedTest(){

  }

  @Test
  @DisplayName("😱")
  void abortedTest(){
    assumeTrue("abc".contains("z"));
    fail("Test should have bean aborted.");
  }

}
