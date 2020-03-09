package com.kpztech.practice.base.serialize;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class SonPerson extends SerialPerson implements Serializable {

  // transient 关键字标识的字段不会被序列化。
  private transient String country;

  public SonPerson(Long id, String name, Integer age) {
    super(id, name, age);
  }

  public SonPerson(Long id, String name, Integer age, String country) {
    super(id, name, age);
    this.country = country;
  }
}
