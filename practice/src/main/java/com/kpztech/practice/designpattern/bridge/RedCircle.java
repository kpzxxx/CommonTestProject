package com.kpztech.practice.designpattern.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedCircle implements DrawAPI {

  @Override
  public void drawCircle(int radius, int x, int y) {
    log.info("Drawing Circle[ color: red, radius: {}, x: {}, y: {}", radius, x, y);
  }
}
