package com.kpztech.practice.mvc.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

  private int code;
  private String message;

  public CommonResponse(int code, Exception e) {
    this.code = code;
    this.message = e.getMessage();
  }

  public static CommonResponse of(ResponseEnum responseEnum) {
    return new CommonResponse(responseEnum.getCode(), responseEnum.getMessage());
  }

}
