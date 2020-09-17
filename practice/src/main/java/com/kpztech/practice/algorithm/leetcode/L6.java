package com.kpztech.practice.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class L6 {
	@Test
	public void test() {
		String s = "LEETCODEISHIRING";
		System.out.println(convert(s, 3));
		System.out.println(convert(s, 4));
	}

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		List<StringBuilder> list = new ArrayList<>();
		boolean goingDown = false;
		int currentRow = 0;

		for (char c : s.toCharArray()) {
			if (list.size() <= currentRow) {
				list.add(currentRow, new StringBuilder());
			}

			list.get(currentRow).append(c);
			if (currentRow == 0 || currentRow == numRows - 1) {
				goingDown = !goingDown;
			}
			currentRow += goingDown ? 1 : -1;
		}

		StringBuilder result = new StringBuilder();
		list.forEach(x -> result.append(x.toString()));

		return result.toString();
	}
}
