package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.rocketmq.producer.RocketMQSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MQController {

  @Autowired
  private RocketMQSender rocketMQSender;

  @RequestMapping("/send")
  public String send(@RequestParam("msg") String msg) {
    rocketMQSender.send(msg);
    return "success";
  }
}
