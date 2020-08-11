package com.kpztech.practice.algorithm;

/**
 * 求 a,b的最大公约数
 */
public class BiggestDividerTest {
	public static void main(String[] args) {
		System.out.println(gcd1(25, 5));
		System.out.println(gcd2(100, 18));
		System.out.println(gcd3(1372, 2744));
	}

	// 辗转相除法
	private static int gcd1(int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);
		if (small == 0) {
			return big;
		}
		return gcd1(small, big % small);
	}

	// 更相减损法
	private static int gcd2(int a, int b) {
		if (a == b) {
			return a;
		}
		int big = Math.max(a, b);
		int small = Math.min(a, b);
		return gcd2(big - small, small);
	}

	// 最优算法
	private static int gcd3(int a, int b) {
		if (a == b) {
			return a;
		}

		if ((a & 1) == 0 && (b & 1) == 0) {
			// 偶偶
			return gcd3(a >> 1, b >> 1) << 1;
		} else if ((a & 1) == 0 && (b & 1) != 0) {
			// 偶奇
			return gcd3(a >> 1, b);
		} else if ((a & 1) != 0 && (b & 1) == 0) {
			// 奇偶
			return gcd3(a, b >> 1);
		} else {
			// 奇奇
			int big = Math.max(a, b);
			int small = Math.min(a, b);
			return gcd3(big - small, small);
		}
	}
}
