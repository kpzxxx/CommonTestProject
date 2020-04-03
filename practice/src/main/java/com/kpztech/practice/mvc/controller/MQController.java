package com.kpztech.practice.mvc.controller;

import com.kpztech.practice.rocketmq.producer.RocketMQProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MQController {

	@Autowired
	private RocketMQProducer rocketMQProducer;

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
