package com.kpztech.practice.algorithm.leetcode;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。（不要转成字符串）
 * 2020-06-10
 */
public class Palindrome {

	public static void main(String[] args) {
		List<Integer> inputs = Lists.newArrayList(10, 0, 121, 12345, -100, 1234554321);
		System.out.println(JSON.toJSON(inputs));
		List<Boolean> outputs = inputs.stream().map(Palindrome::isPalindrome).collect(Collectors.toList());
		System.out.println(JSON.toJSON(outputs));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x /= 10;
		}
		return x == rev || x == rev / 10;
	}

}
