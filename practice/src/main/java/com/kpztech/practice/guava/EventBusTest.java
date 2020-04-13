package com.kpztech.practice.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventBusTest {

  public static void main(String[] args) {
    EventBusTest eventBusTest = new EventBusTest();
    Executor executor = Executors.newFixedThreadPool(2);
    EventBus eventBus = new AsyncEventBus(executor);

    eventBus.register(eventBusTest);

    EventBusMsg msg = new EventBusMsg();
    msg.setName("ABC");

    eventBus.post(msg);
    System.out.println("Post success!");


  }

  @Subscribe
  @AllowConcurrentEvents
  public void process1(EventBusMsg msg) {
    log.info("[P1] Received:{}",JSON.toJSONString(msg));
  }

  @Subscribe
  @AllowConcurrentEvents
  public void process2(EventBusMsg msg) {
    log.info("[P2] Received:{}",JSON.toJSONString(msg));
  }

  @Data
  private static class EventBusMsg {

    private String name;
  }

}
