package com.kpztech.practice.redis.util;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

@Component
public class RedissonUtil {
  private static RedissonClient client;

  static {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");
    client = Redisson.create(config);
  }

  public void lock(String key){
    RLock lock = client.getLock(key);
    lock.lock();
  }

  public void unlock(String key){
    RLock lock = client.getLock(key);
    lock.unlock();
  }

  public int getLockStatus(String key){
    RLock lock = client.getLock(key);
    return lock.getHoldCount();
  }
}
