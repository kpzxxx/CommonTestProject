package com.kpztech.practice.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。（不要转成字符串）
 * 2020-06-10
 */
public class Palindrome {

	public static void main(String[] args) {
		int i1 = 123454321;
		int i2 = 122;
		int i3 = -100;
		System.out.println(Lists.newArrayList(isPalindrome1(i1), isPalindrome1(i2), isPalindrome1(i3)));
		System.out.println(Lists.newArrayList(isPalindrome2(i1), isPalindrome2(i2), isPalindrome2(i3)));
		System.out.println(Lists.newArrayList(isPalindrome(i1), isPalindrome(i2), isPalindrome(i3)));
	}


	// 字符串法 O(n)
	public static boolean isPalindrome1(int x) {
		if (x < 0) {
			return false;
		} else if (x == 0) {
			return true;
		}
		String s = String.valueOf(x);
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length / 2 + 1; i++) {
			if (chars[i] != chars[chars.length - i - 1]) {
				return false;
			}
		}
		return true;
	}

	// 拿出每位进行比较 2O(log10n)
	public static boolean isPalindrome2(int x) {
		if (x < 0) {
			return false;
		} else if (x == 0) {
			return true;
		}
		double log10 = Math.log10(x);
		if(log10 %1 == 0){
			log10 += 0.1;
		}
		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < log10; i++) {
			integers.add(x % 10);
			x /= 10;
		}
		for (int i = 0; i < integers.size() / 2 + 1; i++) {
			if (!integers.get(i).equals(integers.get(integers.size() - i - 1))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		// 反序数字
		int rev = 0;
		while (x > rev) {   // 循环步长 /10
			rev = rev * 10 + x % 10; // <--解法核心 rev的构造
			x /= 10;
		}
		// 偶数走到x==rev, 奇数走到x==rev/10
		return x == rev || x == rev / 10;
	}

}
