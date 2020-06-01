package com.kpztech.practice.base;

import com.kpztech.practice.util.KTechDateUtils;

public class DateTest {

  public static void main(String[] args) {
//    System.out.println(KTechDateUtils.getDaysBefore(3));
//    System.out.println(new Date().before(KTechDateUtils.getDaysBefore(1)));
//    System.out.println(KTechDateUtils.getDaysBefore(1).before(KTechDateUtils.getDaysBefore(1)));
//    System.out.println(KTechDateUtils.getDaysBefore(1).before(KTechDateUtils.getDaysBefore(1)));
//    System.out.println(KTechDateUtils.getDaysBefore(2).before(KTechDateUtils.getDaysBefore(1)));
    System.out.println(KTechDateUtils.format(KTechDateUtils.getDaysBefore(-1, 13)));


  }

}
