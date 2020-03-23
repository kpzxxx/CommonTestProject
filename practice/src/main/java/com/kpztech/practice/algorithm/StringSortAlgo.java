package com.kpztech.practice.algorithm;

import com.kpztech.practice.test.string.StringTest;

import java.util.Arrays;

/**
 * 输入一串字符，包含数字[0-9]和小写字母[a-z]，要求字母按字典序排序，数字从小到大排列，数字在前，字母在后
 */
public class StringSortAlgo {

    public static void main(String[] args) {
        String s = StringTest.randomStr(10);
        System.out.println(sort(s));
    }

    private static String sort(String str) {
        // Your code
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = Arrays.toString(chars);

        return str;


    }

    // 快速排序
    private static String quickSort(char[] pData, int left, int right) {
        int first, i, j;
        char temp;
        i = left;
        j = right;
        first = pData[left];
        return null;
    }
}
