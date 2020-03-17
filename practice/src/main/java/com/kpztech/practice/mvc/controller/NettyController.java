package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.netty.SpringNettyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/netty")
public class NettyController {

  @Autowired
  private SpringNettyUtil springNettyUtil;

  @RequestMapping("/send")
  public String test(@RequestParam("msg") String msg) {
//    springNettyUtil.send(msg);
    return "Success!";
  }

}
