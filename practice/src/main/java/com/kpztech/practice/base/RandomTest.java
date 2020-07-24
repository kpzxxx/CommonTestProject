package com.kpztech.practice.base;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RandomTest {

  public static void main(String[] args) {
    // 种子相同，结果就相同吗？
//    testSeed();

    // LCG
//    testLCG();

    // Knuth洗牌算法
//      knuthShuffle();

    // 谁能在杭州车牌摇号中胜出？
//    lottery();
  }

  @Test
  public void testRandomSeed() {
    int bound = 1000;
    Random random1 = new Random(0);
    Random random2 = new Random(0);
    for (int i = 0; i < 100; i++) {
      System.out.println(random1.nextInt(bound) + "-" + random2.nextInt(bound));
    }
  }

  @Test
  public void testSecureRandomSeed() {
    int bound = 1000;
    SecureRandom random1 = new SecureRandom("0".getBytes());
    SecureRandom random2 = new SecureRandom("0".getBytes());
    for (int i = 0; i < 100; i++) {
      System.out.println(random1.nextInt(bound) + "-" + random2.nextInt(bound));
    }
  }

  @Test
  public void testLCG() {
    int m = 9;
//    int a = 2, c = 0, seed = 1;
//    int a = 2, c = 0, seed = 3;
    int a = 4, c = 1, seed = 0;
    List<Integer> resultList = Lists.newArrayList();
    int result;
    resultList.add(seed);

    while (true) {
      result = (seed * a + c) % m;
      if (resultList.contains(result)) {
        resultList.add(result);
        break;
      } else {
        resultList.add(result);
        seed = result;
      }
    }
    System.out.println(JSON.toJSONString(resultList));
  }

  @Test
  public void knuthShuffle() {
    List<Integer> list = Lists.newArrayList();
    Random random = new Random();
    for (int i = 1; i <= 10; i++) {
      list.add(i);
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      // 随机从0-i间选一个数
      int selection = random.nextInt(i + 1);

      // 交换selection和i的位置
      int temp = list.get(i);
      list.set(i, list.get(selection));
      list.set(selection, temp);
    }

    System.out.println(JSON.toJSONString(list));

  }

  /**
   * 杭州市2020年6月份小客车增量指标摇号结束。本月以摇号方式向单位和个人配置增量指标5333个，其中个人指标4693个，单位指标640个。参与本期摇号的个人有效编码数868183个，单位有效编码数21729个。
   */
  @Test
  public void lottery() {
    int bound = 868183;
//    long seed = 987436;
    Random userNo = new Random();
    Random lotteryMech = new Random();

    // 生成抽奖号
    Map<Integer, String> userMap = Maps.newConcurrentMap();
    userMap.put(userNo.nextInt(bound), "康普滋");
    userMap.put(userNo.nextInt(bound), "孙长纪");
    userMap.put(userNo.nextInt(bound), "王博文");
    userMap.put(userNo.nextInt(bound), "彭博文");
    userMap.put(userNo.nextInt(bound), "杜标");
    userMap.put(userNo.nextInt(bound), "祖宝红");
    userMap.put(userNo.nextInt(bound), "葛文浩");
    userMap.put(userNo.nextInt(bound), "徐志毅");
    userMap.put(userNo.nextInt(bound), "黄浩星");
    userMap.put(userNo.nextInt(bound), "汤师爷");
    userMap.put(userNo.nextInt(bound), "董亮亮");
    userMap.put(userNo.nextInt(bound), "汪永杰");

    // 摇号
    int winnerNum = 4693;
    int times = 1;

//    lottery:
//    while (true) {
    while (!userMap.isEmpty()) {

      List<Integer> result = Lists.newArrayList();
      for (int i = 0; i < winnerNum; i++) {
        result.add(lotteryMech.nextInt(bound));
      }

      // 开奖！！！
      for (Integer r : result) {
        if (userMap.containsKey(r)) {
          log.info("恭喜【{}】在摇号【{}】次后通过中奖号码【{}】中奖!!!", userMap.get(r), times, r);

          userMap.remove(r);
//          break lottery;
        }
      }

      times++;
    }

  }

}
