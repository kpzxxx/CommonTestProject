package com.kpztech.practice.guava;

import com.google.common.util.concurrent.RateLimiter;
import com.kpztech.practice.util.KTechDateUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateLimiterTest {

  public static void main(String[] args) {
    RateLimiter rateLimiter = RateLimiter.create(1);

    for(int i=0; i<10000; i++){
      rateLimiter.acquire();
      log.info(KTechDateUtils.now());

    }


  }

}
