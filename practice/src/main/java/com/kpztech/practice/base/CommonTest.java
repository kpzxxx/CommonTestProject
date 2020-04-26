package com.kpztech.practice.base;

import com.alibaba.fastjson.JSON;

import org.apache.zookeeper.ZooDefs;

public class CommonTest {

  public static void main(String[] args) {

    System.out.println(JSON.toJSONString(ZooDefs.Perms.ALL));
  }

}
