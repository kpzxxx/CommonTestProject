package com.kpztech.practice.test.test4;

//import java.util.Scanner;

/**
 * 小明最近在做病毒自动检测，他发现，在某些library 的代码段的二进制表示中，如果包含子串并且恰好有k个1，就有可能有潜在的病毒。library的二进制表示可能很大，并且子串可能很多，人工分析不可能，于是他想写个程序来先算算到底有多少个子串满足条件。如果子串内容相同，但是开始或者结束位置不一样，则被认为是不同的子串。
 * 注：子串一定是连续的。例如"010"有6个子串，分别是 "0, "1", "0", "01", "10", "010"
 * 输入描述:
 * 第一行是一个整数k，表示子串中有k个1就有可能是病毒。其中 0 <= k <= 1 000 000
 * 第二行是一个字符串，就是library的代码部分的二进制表示。字符串长度 <= 1 000 000。并且字符串中只包含"0"或"1".
 * 输出描述:
 * 输出一个整数，所有满足只包含k个1的子串的个数。
 */
public class Test4 {
	public static void main(String[] args) {
		int k = 1;
		String s = "1010";
		System.out.println(countDP(k, s));
	}


	private static int count(int k, String s) {
		int l = s.length();
		int fCount = 0;
		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j <= l; j++) {
				String sub = s.substring(i, j);
				if (sub.length() < k) {
					continue;
				}
				char[] chars = sub.toCharArray();
				int count = 0;
				for (int m = 0; m < sub.length(); m++) {
					if (chars[m] == '1') {
						count++;
					}
				}
				if (count == k) {
//					System.out.println("Got one: " + sub);
					fCount++;
				}
				if (count > k) {
					break;
				}
			}
		}
		return fCount;
	}

	// 动态规划
	private static int countDP(int k, String s) {
		int num = 0;
		int[] dp = new int[k + 2];
		int result = 0;
		dp[0] = 1;
		for (char c : s.toCharArray()) {
			if (c == '1'){
				num++;
			}
			if (num - k >= 0){
				result += dp[(num - k) % (k + 2)];
			}
			dp[(num + 1) % (k + 2)] = 0;
			dp[num % (k + 2)]++;
		}
		return result;
	}
}
