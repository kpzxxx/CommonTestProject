package com.kpztech.practice.rocketmq.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.context.annotation.Bean;

//@Configuration
public class ConsumerConfig {

  @Bean
  public DefaultMQPushConsumer consumer() throws MQClientException {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("Test-group");
    consumer.setNamesrvAddr("127.0.0.1:9876");
    consumer.setInstanceName("practice-consumer");
    consumer.subscribe("test-topic", "some-tag");

//    consumer.registerMessageListener(new RocketMQHandler());

    consumer.start();
    return consumer;
  }

}
