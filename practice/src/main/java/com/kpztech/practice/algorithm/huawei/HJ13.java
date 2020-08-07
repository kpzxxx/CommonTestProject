package com.kpztech.practice.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */
public class HJ13 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()){
			String s1 = s.nextLine();
			System.out.println(reverse(s1));
		}
	}

	public static String reverse(String sentence){
		String[] sent = sentence.split(" ");
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=sent.length-1; i>=0; i--){
			stringBuilder.append(sent[i]).append(" ");
		}
		String result = stringBuilder.toString();
		return result.trim();
	}

}
