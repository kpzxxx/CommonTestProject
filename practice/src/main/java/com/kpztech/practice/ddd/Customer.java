package com.kpztech.practice.ddd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 领域模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer {
  private String id;
  private String firstName;
  private String lastName;

}
