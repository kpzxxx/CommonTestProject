package com.kpztech.practice.boot.mvc.entity;

import lombok.Data;

@Data
public class StudentEntity {
  private Long id;
  private String phone;
  private Integer gender;
  private String name;
  private byte[] pic;
  private String picName;
}
