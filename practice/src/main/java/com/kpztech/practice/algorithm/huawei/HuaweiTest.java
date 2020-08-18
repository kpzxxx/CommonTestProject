package com.kpztech.practice.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

public class HuaweiTest {
	public static void main(String[] args) {
		hj14();
	}

	/**
	 * 求句子最后一个单词的长度
	 */
	public static void hj1() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String[] strings = scanner.nextLine().split(" ");
			System.out.println(strings[strings.length - 1].length());
		}
	}

	/**
	 * 给定n个字符串，请对n个字符串按照字典序排列。
	 * IN:输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
	 * OUT:数据输出n行，输出结果为按照字典序排列的字符串。
	 */
	public static void hj14() {
		Scanner scanner = new Scanner(System.in);

		int i = 0;
		int lines = 0;
		TreeSet<String> treeSet = new TreeSet<>();
		while (scanner.hasNext()) {
			if (i == 0) {
				lines = scanner.nextInt();
				i++;
			} else {
				String string = scanner.nextLine();
				if (string != null && !string.equals("")) {
					treeSet.add(string);
					i++;
				}
			}

			if (i == lines + 1) {
				break;
			}
		}
		treeSet.forEach(System.out::println);
	}


	/**
	 * •计算一个数字的立方根，不使用库函数
	 */
	public static void hj107() {
//		while (true){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(getCubeRoot(Double.parseDouble(br.readLine())));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		}
	}

	// 牛顿迭代公式
	public static double getCubeRoot(double d1) {
		double x = 1;
		double x0 = x - (x * x * x - d1) / (3 * x * x);
		while (x - x0 > 1e-15 || x - x0 < -1e-15) {
			x = x0;
			x0 = x - (x * x * x - d1) / (3 * x * x);
		}
		return (double) Math.round(x0 * 10.0) / 10.0;
	}

	/**
	 * 输入多行：3， 2,2,1 去重+排序 -> TreeSet
	 */
	public static void hj3() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			TreeSet<Integer> treeSet = new TreeSet<>();
			for (int i = 0; i < num; i++) {
				treeSet.add(scanner.nextInt());
			}
			treeSet.forEach(System.out::println);
		}
	}

	/**
	 * 输入2行，找字符数 ABDCDG A -> 1
	 */
	public static void hj2() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s1 = scanner.nextLine();
			String s2 = scanner.nextLine();
			char[] c1 = s1.toUpperCase().toCharArray();
			char c2 = s2.toUpperCase().toCharArray()[0];
			int num = 0;
			for (char c : c1) {
				if (c == c2) {
					num++;
				}
			}
			System.out.println(num);
		}
	}

	public static void hj29() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s1 = scanner.nextLine();
			String s2 = scanner.nextLine();
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();

			System.out.println(enDecode(c1, true));
			System.out.println(enDecode(c2, false));
		}
	}

	private static String enDecode(char[] cs, boolean encode) {
		for (int i = 0; i < cs.length; i++) {
			char c = cs[i];
			if (c > 'a' && c < 'z') {
				if (encode) {
					cs[i] = (char) (c - 31);
				} else {
					cs[i] = (char) (c - 33);
				}
			} else if (c == 'z') {
				if (encode) {
					cs[i] = 'A';
				} else {
					cs[i] = 'Y';
				}
			} else if (c > 'A' && c < 'Z') {
				if (encode) {
					cs[i] = (char) (c + 33);
				} else {
					cs[i] = (char) (c + 31);
				}
			} else if (c == 'Z') {
				if (encode) {
					cs[i] = 'a';
				} else {
					cs[i] = 'y';
				}
			} else if (c == 'a') {
				if (encode) {
					cs[i] = 'B';
				} else {
					cs[i] = 'Z';
				}
			} else if (c == 'A') {
				if (encode) {
					cs[i] = 'b';
				} else {
					cs[i] = 'z';
				}
			} else if (c > '0' && c < '9') {
				if (encode) {
					cs[i] = (char) (c + 1);
				} else {
					cs[i] = (char) (c - 1);
				}
			} else if (c == '9') {
				if (encode) {
					cs[i] = '0';
				} else {
					cs[i] = '8';
				}
			} else if (c == '0') {
				if (encode) {
					cs[i] = '1';
				} else {
					cs[i] = '9';
				}
			}
		}
		return new String(cs);
	}

}
