package com.kpztech.practice.rocketmq.producer;

import com.alibaba.fastjson.JSON;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RocketMQSender {
  @Autowired
  private RocketMQTemplate rocketMQTemplate;

  public void send(String msg) {
    log.info("[Producer]Producer start to send message: " + JSON.toJSONString(msg));
    try {
      rocketMQTemplate.convertAndSend("test-topic", msg);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
