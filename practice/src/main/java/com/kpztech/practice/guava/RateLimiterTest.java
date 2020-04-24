package com.kpztech.practice.guava;

import com.google.common.util.concurrent.RateLimiter;
import com.kpztech.practice.util.KTechDateUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateLimiterTest {

  public static void main(String[] args) {
    RateLimiter rateLimiter = RateLimiter.create(100);

//    for(int i=0; i<10000; i++){
    log.info(KTechDateUtils.now());

    rateLimiter.acquire(10000000);
    log.info(KTechDateUtils.now());

    for(int i=0; i<10; i++){
      rateLimiter.acquire(200);
      log.info(KTechDateUtils.now());
    }


//    }

  }

}
