package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.mvc.request.RedisSetRequest;
import com.kpztech.practice.redis.util.RedisUtil;
import com.kpztech.practice.redis.util.RedissonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

  @Autowired
  private RedisUtil redisUtil;

  @Autowired
  private RedissonUtil redissonUtil;

  @RequestMapping(path = "/set", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
  public String set(@RequestBody RedisSetRequest request) {
    redisUtil.setString(request.getKey(), request.getValue());
    return redisUtil.getString(request.getKey());
  }

  @RequestMapping(path = "/get")
  public String get(@RequestParam(name = "key") String key) {
    return redisUtil.getString(key);
  }

  @RequestMapping(path = "/lock")
  public String lock() {
    String key = "stock";
    System.out.println("[" + Thread.currentThread().getName() + "]Try to lock.");
    try {
      // 重入，锁3次
      for (int i = 0; i < 3; i++) {
        Thread.sleep(1000);
        redissonUtil.lock(key);
        System.out.println("[" + Thread.currentThread().getName() + "] lock status: " + redissonUtil.getLockStatus(key));
      }
      // 3次解锁
      for (int i = 0; i < 3; i++) {
        Thread.sleep(1000);
        redissonUtil.unlock(key);
        System.out.println("[" + Thread.currentThread().getName() + "] lock status: " + redissonUtil.getLockStatus(key));
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
      return "Failed!";
    }
    return "Success!";
  }

}
