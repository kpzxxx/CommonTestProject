package com.kpztech.practice.mvc.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kpztech.practice.base.spring.aop.ShowTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {

  private int code;
  private String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private T data;

  public CommonResponse(int code, Exception e) {
    this.code = code;
    this.message = e.getMessage();
  }

  public static <@ShowTime T> CommonResponse<T> of(ResponseEnum responseEnum) {
    return new CommonResponse<>(responseEnum.getCode(), responseEnum.getMessage(), null);
  }

  public static <T> CommonResponse<T> of(T data) {
    return new CommonResponse<>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(), data);
  }
}
