package com.kpztech.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

public class DisplayNameGeneratorTest {

  @Nested
  @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
  class AYearIsNotSupported {

    @Test
    void ifItIsZero() {

    }

    @DisplayName("A negative value for year is not supported by the leap year computation.")
    @ParameterizedTest(name = "For example, year {0} is not supported.")
    @ValueSource(ints = {-1, -4})
    void ifItIsNegative(int year) {
      System.out.println(year);
    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences.class)
    class AYearIsALeapYear {

      @Test
      void ifItIsDivisibleBy4ButNotBy100() {

      }

      @ParameterizedTest(name = "Year {0} is a leap year.")
      @ValueSource(ints = {2016, 2020, 2048})
      void ifItIsOneOfTheFollowingYears(int year) {
        System.out.println(year);
      }
    }
  }

  static class IndicativeSentences extends DisplayNameGenerator.ReplaceUnderscores {

    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
      return super.generateDisplayNameForClass(testClass);
    }

    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
      return super.generateDisplayNameForNestedClass(nestedClass) + "...";
    }

    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
      String displayName = testClass.getSimpleName() + " " + testMethod.getName();

      return displayName.replace("Not", " ") + ".";
    }
  }

}
