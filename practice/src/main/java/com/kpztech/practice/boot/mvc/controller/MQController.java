package com.kpztech.practice.boot.mvc.controller;

import com.kpztech.practice.boot.rocketmq.producer.RocketMQProducer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MQController {

	private final RocketMQProducer rocketMQProducer;

	public MQController(RocketMQProducer rocketMQProducer) {
		this.rocketMQProducer = rocketMQProducer;
	}

	@RequestMapping("/send")
	public String send(@RequestParam("msg") String msg) {

		try {
			rocketMQProducer.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed, e:" + e.getMessage();
		}
		return "success";
	}
}
