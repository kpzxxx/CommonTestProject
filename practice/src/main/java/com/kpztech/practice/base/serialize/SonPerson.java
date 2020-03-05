package com.kpztech.practice.base.serialize;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
public class SonPerson extends SerialPerson implements Serializable {

  private String country;

  public SonPerson(Long id, String name, Integer age) {
    super(id, name, age);
  }

  public SonPerson(Long id, String name, Integer age, String country) {
    super(id, name, age);
    this.country = country;
  }
}
