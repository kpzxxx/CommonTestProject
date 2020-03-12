package com.kpztech.practice.base.spring;

import org.springframework.stereotype.Component;

@Component
public class MetalSinger implements Singer {

  @Override
  public String sing() {
    return "Metal singer.";
  }
}
