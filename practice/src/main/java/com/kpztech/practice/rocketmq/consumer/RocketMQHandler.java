package com.kpztech.practice.rocketmq.consumer;

import com.alibaba.fastjson.JSON;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RocketMQHandler implements MessageListenerConcurrently {

  @Override
  public ConsumeConcurrentlyStatus consumeMessage(
      List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
    try {
      for (MessageExt ext : msgs) {
        log.info("[Consumer]Consume message: " + JSON.toJSONString(new String(ext.getBody())));
      }
    } catch (Exception e) {
      e.printStackTrace();
      return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }

    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
  }
}
