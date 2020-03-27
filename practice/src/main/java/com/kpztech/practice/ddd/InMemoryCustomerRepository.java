package com.kpztech.practice.ddd;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 仓库层，数据层
 */
@Component
public class InMemoryCustomerRepository implements CustomerRepository {

  private Map<String, Customer> customerMap = new ConcurrentHashMap<>();

  @Override
  public Customer get(String id) {
    return customerMap.get(id);
  }

  @Override
  public void add(Customer customer) {
    customerMap.put(customer.getId(), customer);
  }

  @Override
  public void update(Customer customer) {
    customerMap.put(customer.getId(), customer);
  }

  @Override
  public Collection<Customer> all() {
    return Collections.unmodifiableCollection(customerMap.values());
  }
}
