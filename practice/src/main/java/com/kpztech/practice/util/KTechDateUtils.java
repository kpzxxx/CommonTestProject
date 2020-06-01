package com.kpztech.practice.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class KTechDateUtils {

  public static String now() {
    return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
  }

  public static boolean isBefore(Date date1, Date date2) {
    return date1.before(date2);
  }

  public static Date getDaysBefore(int days) {
    return DateUtils.addDays(new Date(), -days);
  }

  public static Date getDaysBefore(int days, int hours) {
    return DateUtils.addHours(DateUtils.addDays(new Date(), -days), -hours);
  }

  public static String format(Date date) {
    return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
  }

}
