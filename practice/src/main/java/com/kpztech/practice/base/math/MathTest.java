package com.kpztech.practice.base.math;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MathTest {

  public static void main(String[] args) {
    int allNum = 738;
    int sameNum = 522;
    int allDiffNum = 5938;

    long diffNum = allNum - sameNum;
    float diffRate =
        new BigDecimal(diffNum).divide(new BigDecimal(allNum), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).floatValue();
    log.info("Diff Rate: {}%", diffRate);

    float averageDiffNum = new BigDecimal(allDiffNum).divide(new BigDecimal(diffNum), 2, BigDecimal.ROUND_HALF_UP)
                                                     .setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    log.info("Average diff num: {}", averageDiffNum);


  }

}
