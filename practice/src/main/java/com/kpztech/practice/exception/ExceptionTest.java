package com.kpztech.practice.exception;

public class ExceptionTest {

  public static void main(String[] args) {
    StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
    for(StackTraceElement element : stackTrace){
      System.out.println(element.getClassName());
    }
  }

}
