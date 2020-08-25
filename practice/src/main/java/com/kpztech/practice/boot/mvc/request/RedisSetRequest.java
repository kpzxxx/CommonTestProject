package com.kpztech.practice.boot.mvc.request;

import lombok.Data;

@Data
public class RedisSetRequest {
  private String key;
  private String value;

}
