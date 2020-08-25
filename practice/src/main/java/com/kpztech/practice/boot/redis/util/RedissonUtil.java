package com.kpztech.practice.boot.redis.util;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedissonUtil {

  @Autowired
  private RedissonClient client;

  public void lock(String key) {
    RLock lock = client.getLock(key);
    lock.lock();
  }

  public void unlock(String key) {
    RLock lock = client.getLock(key);
    lock.unlock();
  }

  public int getLockStatus(String key) {
    RLock lock = client.getLock(key);
    return lock.getHoldCount();
  }
}
