package com.kpztech.practice.mvc.request;

import lombok.Data;

@Data
public class RedisSetRequest {
  private String key;
  private String value;

}
