package com.kpztech.practice.boot.redis.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

@Component
public class RedisUtil {

  @Resource
  private RedisTemplate<String, Object> stringRedisTemplate;

  /**
   * 设置过期时间
   *
   * @param key  key
   * @param time 过期时间（秒）
   * @return 是否成功
   */
  public boolean expire(String key, long time) {
    try {
      if (time > 0) {
        stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 获取过期时间
   *
   * @param key key
   * @return 过期时间（秒）
   */
  public long getExpire(String key) {
    Long expireTime = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
    return expireTime == null ? -1 : expireTime;
  }

  /**
   * 是否含有key
   *
   * @param key key
   * @return 是否有
   */
  public boolean hasKey(String key) {
    try {
      Boolean hasKey = stringRedisTemplate.hasKey(key);
      return hasKey == null ? false : hasKey;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 获取value
   *
   * @param key key
   * @return value
   */
  public Object get(String key) {
    return key == null ? null : stringRedisTemplate.opsForValue().get(key);
  }

  /**
   * 获取string value
   *
   * @param key key
   * @return value
   */
  public String getString(String key) {
    return key == null ? null : (String) stringRedisTemplate.opsForValue().get(key);
  }

  /**
   * 设置值
   *
   * @param key   key
   * @param value value
   * @return 是否成功
   */
  public boolean set(String key, Object value) {
    try {
      stringRedisTemplate.opsForValue().set(key, value);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 设置值
   *
   * @param key   key
   * @param value json形式的value
   * @return 是否成功
   */
  public boolean setString(String key, String value) {
    try {
      stringRedisTemplate.opsForValue().set(key, value);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 设置值
   *
   * @param key   key
   * @param value value
   * @param time 过期时间
   * @return 是否成功
   */
  public boolean set(String key, Object value, long time) {
    try {
      stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
