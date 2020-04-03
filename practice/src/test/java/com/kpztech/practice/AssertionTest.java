package com.kpztech.practice;

import com.kpztech.practice.base.spring.bean.Person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionTest {

  private final Person person = new Person();

//  @InjectMocks
//  private final Calculator calculator;

  @Test
  void groupedAssertions(){
    person.setName("ABC");
    person.setAddress("DEF");
    assertAll("person",
              () -> assertEquals("DDB", person.getName()),
              () -> assertEquals("FDF", person.getAddress())
              );
  }

}
