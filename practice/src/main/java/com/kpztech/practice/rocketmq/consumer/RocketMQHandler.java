package com.kpztech.practice.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "Test-group")
public class RocketMQHandler implements RocketMQListener<String> {

  @Override
  public void onMessage(String s) {
    log.info("[Consumer]Consume message: " + s);
  }
}
