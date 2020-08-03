package com.kpztech.practice.spi;

import org.junit.Test;

import java.util.ServiceLoader;

public class SPITest {
  @Test
  public void test1(){
    ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
    System.out.println("Java SPI");
    serviceLoader.forEach(Robot::sayHello);

  }

}
