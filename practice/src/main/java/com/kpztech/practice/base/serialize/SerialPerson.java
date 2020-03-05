package com.kpztech.practice.base.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerialPerson {


  private static final long serialVersionUID = -81L;

  private Long id;
  private String name;
  private Integer age;
}
