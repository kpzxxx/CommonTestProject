package com.kpztech.practice.algorithm.huawei;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {

      List<Integer> queue = new ArrayList<>();
      List<Integer> workerList = new ArrayList<>();
      List<Integer> orderList = new ArrayList<>();
      // （执行者号码:需要时间)
      Map<Integer, Integer> timeMap = new LinkedHashMap<>();
      Map<Integer, List<Integer>> endMap = new LinkedHashMap<>();

      String s1 = scanner.nextLine();
      String s2 = scanner.nextLine();

      String[] sTime = s1.split(" ");
      String[] workerInfo = s2.split(" ");
      int queueLength = Integer.parseInt(workerInfo[0]);
      int workerSize = Integer.parseInt(workerInfo[1]);

      int discardSize = 0;
      int completeTime = 0;

      for (int i = 0; i < sTime.length; i++) {
        if (i % 2 == 0) {
          timeMap.put(Integer.parseInt(sTime[i]), Integer.parseInt(sTime[i + 1]));
          orderList.add(Integer.parseInt(sTime[i]));
        }
      }

      for (int i = 1; i <= 100000; i++) {
        if (endMap.get(i) != null && endMap.get(i).size() > 0) {
          for (Integer w : endMap.get(i)) {
            workerList.remove(w);
          }
        }
        if (workerList.size() == workerSize) {
          for (int p = 0; p < orderList.size(); p++) {
            int worker = orderList.get(p);
            if (worker == i) {
              if (queue.size() < queueLength) {
                queue.add(worker);
                orderList.remove(p);
              } else {
                orderList.remove(p);
                discardSize++;
              }

              break;
            }
          }
          continue;
        } else {
          for (int p = 0; p < queue.size(); p++) {
            int worker = queue.get(p);
            workerList.add(worker);
            queue.remove(p);

            if (endMap.get(i + timeMap.get(worker)) != null && endMap.get(i + timeMap.get(worker)).size() > 0) {
              List<Integer> tempList = endMap.get(i + timeMap.get(worker));
              tempList.add(worker);
            } else {
              List<Integer> tempList = new ArrayList<>();
              tempList.add(worker);
              endMap.put(i + timeMap.get(worker), tempList);
            }

            break;
          }
          if (workerList.size() == workerSize) {
            for (int p = 0; p < orderList.size(); p++) {
              int worker = orderList.get(p);
              if (worker == i) {
                if (queue.size() < queueLength) {
                  queue.add(worker);
                  orderList.remove(p);
                } else {
                  orderList.remove(p);
                  discardSize++;

                }
                break;
              }
            }
            continue;
          }
        }

        for (int p = 0; p < orderList.size(); p++) {
          int worker = orderList.get(p);
          if (worker == i) {
            workerList.add(worker);
            orderList.remove(p);

            if (endMap.get(i + timeMap.get(worker)) != null && endMap.get(i + timeMap.get(worker)).size() > 0) {
              List<Integer> tempList = endMap.get(i + timeMap.get(worker));
              tempList.add(worker);
            } else {
              List<Integer> tempList = new ArrayList<>();
              tempList.add(worker);
              endMap.put(i + timeMap.get(worker), tempList);
            }
            break;
          }
        }

        if (workerList.size() == 0 && orderList.size() == 0 && queue.size() == 0) {
          completeTime = i;
          break;
        }
      }
      System.out.println(completeTime + " " + discardSize);

    }
  }
}

/*
1 3 2 2 3 3
3 2
1 6 2 4 4 3 6 3
1 2
1 6 2 4 3 3 4 3 6 3
1 2
*/