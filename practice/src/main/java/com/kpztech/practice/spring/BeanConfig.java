package com.kpztech.practice.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
  @Bean
  public Person person(){
    Person person = new Person();
    person.setName("ABC");
    return person;
  }

}
