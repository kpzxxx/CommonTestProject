package com.kpztech.practice.base.cryptology;

import jodd.util.Base64;

public class Base64Test {
	public static void main(String[] args) {
		String s = "ZmFuZ3lpbmdoYW5nQGZveG1haWwuY29t";
		System.out.println(new String(Base64.decode(s)));
	}
}
