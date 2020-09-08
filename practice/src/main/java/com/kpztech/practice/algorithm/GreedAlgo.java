package com.kpztech.practice.algorithm;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Stack;

/**
 * 给出一个整数，从该整数中去掉k个数字，要求剩下的数字形成的新整数尽可能小，输出最小的数字。 如： 1593212 k=3 -> 1212
 */
public class GreedAlgo {

	public String removeDigits(String num, int k) {
		if (k <= 0 || StringUtils.isBlank(num)) {
			return num;
		}

		char[] chars = num.toCharArray();
		Stack<Character> characterStack = new Stack<>();
		char temp = chars[0];
		int i = 0;
		for (char c : chars) {
			if (!characterStack.isEmpty() && temp > c && i < k) {
				while (!characterStack.isEmpty() && characterStack.peek() > c) {
					characterStack.pop();
					i++;
					if (i >= k) {
						break;
					}
				}
			}
			characterStack.push(c);
			temp = c;

		}
		StringBuilder stringBuilder = new StringBuilder();
		while (!characterStack.isEmpty()) {
			stringBuilder.append(characterStack.pop());
		}
		stringBuilder.reverse();
		for (int j = 0; j < stringBuilder.length(); j++) {
			if (stringBuilder.charAt(j) == '0' && stringBuilder.length() > 1) {
				stringBuilder.deleteCharAt(j);
				j--;
			} else {
				break;
			}
		}

		return stringBuilder.toString();
	}

	@Test
	public void test() {
		System.out.println(removeDigits("1593212", 3));
		System.out.println(removeDigits("30200", 1));
		System.out.println(removeDigits("10", 2));
		System.out.println(removeDigits("541270936", 3));
	}

}
