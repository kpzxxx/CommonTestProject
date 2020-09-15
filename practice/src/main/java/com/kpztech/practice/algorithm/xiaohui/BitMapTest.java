package com.kpztech.practice.algorithm.xiaohui;

import org.junit.Test;

/**
 *
 */
public class BitMapTest {
	@Test
	public void test() {
		MyBitMap bitMap = new MyBitMap(128);
//		bitMap.setBit(126);
//		bitMap.setBit(75);
		bitMap.setBit(1);
//		System.out.println(bitMap.getBit(126));
//		System.out.println(bitMap.getBit(78));
	}

	public static class MyBitMap {
		private long[] words;
		private int size;

		public MyBitMap(int size) {
			this.size = size;
			this.words = new long[(getWordIndex(size - 1) + 1)];
		}

		// index和bit比要左移1位，如bit=1时，其实是存在2^1即右边第2位上。
		public void setBit(int bit) {
			if (bit < 0 | bit > size - 1) {
				throw new IndexOutOfBoundsException("超过BitMap有效范围");
			}
			int wordIndex = getWordIndex(bit);
			words[wordIndex] |= (1L << bit);
		}

		// long型存储，所以除以64
		private int getWordIndex(int bit) {
			return bit >> 6;
		}

		public boolean getBit(int bit) {
			if (bit < 0 | bit > size - 1) {
				throw new IndexOutOfBoundsException("超过BitMap有效范围");
			}
			int wordIndex = getWordIndex(bit);
			return (words[wordIndex] & (1L << bit)) != 0;
		}

	}
}
