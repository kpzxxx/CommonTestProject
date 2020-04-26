package com.kpztech.practice.zk;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ZKClient {

  @Value("${zookeeper.url}")
  private String zkUrl;

  @Bean
  public ZooKeeper init() {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    String mark = "kpzTech";
    ZooKeeper zk = null;
    try {
      zk = new ZooKeeper(zkUrl, 1000, event -> {
        log.info("{} watcher 监听事件： {}", mark, event);
        countDownLatch.countDown();
      });
    } catch (IOException e) {
      log.error("ZK init error.", e);
    }
    return zk;
  }

}
