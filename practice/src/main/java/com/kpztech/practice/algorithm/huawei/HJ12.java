package com.kpztech.practice.algorithm.huawei;

import org.junit.Test;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 */
public class HJ12 {

	public static void main(String[] args) {
		answer1();
	}

	public static void answer1() {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			System.out.println(new StringBuilder(s.nextLine()).reverse().toString());
		}
	}

	public static void answer2() {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String str = s.nextLine();
			char[] chars = str.toCharArray();
			char[] rev = new char[chars.length];
			for (int i = 0; i < chars.length; i++) {
				rev[chars.length - i - 1] = chars[i];
			}
			String result = new String(rev);
			System.out.println(result);
		}
	}
}
