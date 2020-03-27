package com.kpztech.practice.ddd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 外部接口层-外部适配器
 */
@RestController
@RequestMapping("/ddd")
public class CustomerController {

  private CustomerApplication application;

  @Autowired
  public CustomerController(CustomerApplication application) {
    this.application = application;
  }

  @PostMapping("/customer")
  public ResponseEntity<Object> create(@RequestParam String firstName, @RequestParam String lastName) {
    application.create(new CreateCustomerCommand(firstName, lastName));
    return ResponseEntity.ok(null);
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<Object> get(@PathVariable("id") String id) {
    return ResponseEntity.ok(application.fetch(id));
  }

  @PatchMapping("/customer/{id}")
  public ResponseEntity<Object> changeFirstName(@PathVariable("id") String id, @RequestParam String firstName) {
    application.changeFirstName(id, firstName);
    return ResponseEntity.ok(null);
  }

  @GetMapping("/customers")
  public ResponseEntity<Object> all() {
    return ResponseEntity.ok(application.all());
  }

}
