package com.kpztech.practice.boot.mvc.common;

public enum StudentGenderEnum {
  MALE(1, "男"),
  FEMALE(2, "女"),
  UNKNOWN(3, "未知"),

  ;

  StudentGenderEnum(Integer gender, String desc) {
    this.gender = gender;
    this.desc = desc;
  }

  private Integer gender;
  private String desc;

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
