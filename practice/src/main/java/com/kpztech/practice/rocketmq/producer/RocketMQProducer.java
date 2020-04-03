package com.kpztech.practice.rocketmq.producer;

import com.alibaba.fastjson.JSON;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RocketMQProducer {

	@Resource
	private RocketMQTemplate rocketMQTemplate;

	public void send(String msg) throws MessagingException {
		log.info("[Producer]Producer start to send message: " + JSON.toJSONString(msg));
		rocketMQTemplate.convertAndSend("test-topic", msg);
	}

}
