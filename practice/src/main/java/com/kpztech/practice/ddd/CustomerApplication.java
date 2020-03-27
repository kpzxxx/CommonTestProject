package com.kpztech.practice.ddd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

/**
 * 应用层
 */
@Component
public class CustomerApplication {

  private CustomerRepository repository;

  @Autowired
  public CustomerApplication(CustomerRepository repository) {
    this.repository = repository;
  }

  public void create(CreateCustomerCommand command) {
    Customer customer = new Customer(UUID.randomUUID().toString(), command.getFirstName(), command.getLastName());
    repository.add(customer);
  }

  public Object fetch(String id) {
    return repository.get(id);
  }

  public void changeFirstName(String id, String firstName) {
    Customer customer = repository.get(id);
    assert customer != null;
    customer.setFirstName(firstName);
    repository.update(customer);
  }

  public Collection<?> all() {
    return repository.all();
  }
}
