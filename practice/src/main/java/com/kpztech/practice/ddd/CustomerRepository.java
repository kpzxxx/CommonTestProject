package com.kpztech.practice.ddd;

import java.util.Collection;

/**
 * 内部适配器
 */
public interface CustomerRepository {

  Customer get(String id);

  void add(Customer customer);

  void update(Customer customer);

  Collection<Customer> all();

}
