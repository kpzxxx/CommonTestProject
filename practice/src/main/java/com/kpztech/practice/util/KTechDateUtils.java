package com.kpztech.practice.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class KTechDateUtils {
  public static String now(){
    return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
  }

}
