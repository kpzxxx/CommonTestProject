package com.kpztech.practice.ddd;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CQRS中的命令
 */
@Data
@AllArgsConstructor
public class CreateCustomerCommand {
  private String firstName;
  private String lastName;

}
