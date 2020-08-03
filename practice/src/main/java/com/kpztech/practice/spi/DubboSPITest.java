package com.kpztech.practice.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

import org.junit.Test;

public class DubboSPITest {
  @Test
  public void sayHello(){
    ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
    Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
    Robot bumblebee = extensionLoader.getExtension("bumblebee");
    optimusPrime.sayHello();
    bumblebee.sayHello();
  }

}
