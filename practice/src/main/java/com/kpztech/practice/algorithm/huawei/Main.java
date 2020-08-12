package com.kpztech.practice.algorithm.huawei;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    while (scanner.hasNext()) {
      String input = scanner.nextLine();
      String[] strings = input.split(",");
      for (String s : strings) {
        list.add(Integer.parseInt(s));
      }

      Map<Integer, Integer> map = new LinkedHashMap<>();
      for (int i : list) {
        if (!map.containsKey(i)) {
          map.put(i, 1);
        } else {
          Integer num = map.get(i);
          num += 1;
          map.put(i, num);
        }
      }

      List<Integer> newList = new ArrayList<>();
      for (Integer i : list) {
        if (!newList.contains(i)) {
          newList.add(i);
        }
      }

      for (int i = 0; i < newList.size(); i++) {
        for (int j = i + 1; j < newList.size(); j++) {
          int i1 = newList.get(i);
          int i2 = newList.get(j);
          if (map.get(i2) > map.get(i1)) {
            newList.set(i, i2);
            newList.set(j, i1);
          } else if (map.get(i2).equals(map.get(i1))) {
            for (int k : list) {
              if (i1 == k) {
                break;
              } else if (i2 == k) {
                newList.set(i, i2);
                newList.set(j, i1);
                break;
              }
            }
          }
        }

      }
      StringBuilder stringBuilder = new StringBuilder();
      for (Integer m : newList) {
        stringBuilder.append(m).append(",");
      }
      String s = stringBuilder.toString();
      System.out.println(s.substring(0, s.length() - 1));

    }


  }

}
// 1,3,3,3,2,4,4,4,5
