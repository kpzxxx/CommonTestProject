package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.mvc.request.RedisSetRequest;
import com.kpztech.practice.redis.util.RedisUtil;

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

  @RequestMapping(path = "/set", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
  public String set(@RequestBody RedisSetRequest request) {
    redisUtil.setString(request.getKey(), request.getValue());
    return redisUtil.getString(request.getKey());
  }

  @RequestMapping(path = "/get")
  public String get(@RequestParam(name = "key") String key) {
    return redisUtil.getString(key);
  }

}
