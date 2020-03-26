package com.kpztech.practice.rocketmq.producer;

import com.alibaba.fastjson.JSON;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RocketMQSender {
  @Autowired
  private DefaultMQProducer producer;

  public void send(String msg) {
    Message message = new Message("test-topic", "some-tag", msg.getBytes());
    log.info("[Producer]Producer start to send message: " + JSON.toJSONString(message));
    try {
      producer.send(message);
    } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
      e.printStackTrace();
    }
  }

}
