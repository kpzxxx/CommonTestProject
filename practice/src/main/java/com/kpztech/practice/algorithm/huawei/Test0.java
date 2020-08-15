package com.kpztech.practice.algorithm.huawei;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 去重+排序：去重后按数量多少排序。
 * 输入：1,3,3,3,2,4,4,4,5 输出：3,4,1,2,5
 */
public class Test0 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    while (scanner.hasNext()) {
      String input = scanner.nextLine();
      String[] strings = input.split(",");
      for (String s : strings) {
        list.add(Integer.parseInt(s));
      }

      // map=(数字：出现的次数）
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

      // list=(去重后的元素，顺序为输入序）
      List<Integer> newList = new ArrayList<>();
      for (Integer i : list) {
        if (!newList.contains(i)) {
          newList.add(i);
        }
      }

      // 比较list里的元素，通过map拿到出现次数，进行排序交换。
      for (int i = 0; i < newList.size(); i++) {
        for (int j = i + 1; j < newList.size(); j++) {
          int i1 = newList.get(i);
          int i2 = newList.get(j);
          if (map.get(i2) > map.get(i1)) {
            newList.set(i, i2);
            newList.set(j, i1);
          } else if (map.get(i2).equals(map.get(i1))) {
            // 如果出现次数相同，i2先出现，需要交换i1和i2顺序.
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
