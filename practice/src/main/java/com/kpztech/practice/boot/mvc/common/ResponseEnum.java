package com.kpztech.practice.boot.mvc.common;

public enum ResponseEnum {
  SUCCESS(0, "成功"),
  STUDENT_NO_PIC(1001, "无图片可加载。"),
  STUDENT_IMG_UPLOAD_ERROR(1002, "上传文件失败。"),

  // ZK
  ZK_DATA_NOT_FOUND(2001,"无可加载的数据."),
  ZK_CREATE_FAILED(2002,"创建zk node失败."),

  ;
  private int code;
  private String message;

  ResponseEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
