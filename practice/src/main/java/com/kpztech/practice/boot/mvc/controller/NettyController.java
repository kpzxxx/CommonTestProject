package com.kpztech.practice.boot.mvc.controller;

import com.kpztech.practice.boot.netty.SpringNettyUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/netty")
public class NettyController {

  private final SpringNettyUtil springNettyUtil;

  public NettyController(SpringNettyUtil springNettyUtil) {
    this.springNettyUtil = springNettyUtil;
  }

  @RequestMapping("/send")
  public String test(@RequestParam("msg") String msg) {
    springNettyUtil.send(msg);
    return "Success!";
  }

}
