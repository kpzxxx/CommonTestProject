package com.kpztech.practice.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 已知公式
 *   DCNALD
 * + GERALD
 * = RCBERT
 * D=5,A-T=0-9,不重复，求其余9个数字
 */
public class NNumAlgorithm {
	public static void main(String[] args) {
		int[] array = new int[10];

		permute(array);
	}

	private static void permute(int[] array) {

		for (int i = 0; i < 10; i++) {
			array[i] = -100;
		}
		array[3] = 5;
		array[9] = 0;

		int times = 0;

		for (int i = 0; i < 10; i++) {
			int[] clone1 = array.clone();
			Arrays.sort(clone1);
			if (Arrays.binarySearch(clone1, i) >= 0) {
				continue;
			} else {
				array[0] = i;
			}
			for (int j = 0; j < 10; j++) {
				int[] clone2 = array.clone();
				Arrays.sort(clone2);
				if (Arrays.binarySearch(clone2, j) >= 0) {
					continue;
				} else {
					array[1] = j;
				}
				for (int k = 0; k < 10; k++) {
					int[] clone3 = array.clone();
					Arrays.sort(clone3);
					if (Arrays.binarySearch(clone3, k) >= 0) {
						continue;
					} else {
						array[2] = k;
					}
					for (int m = 0; m < 10; m++) {
						int[] clone4 = array.clone();
						Arrays.sort(clone4);
						if (Arrays.binarySearch(clone4, m) >= 0) {
							continue;
						} else {
							array[4] = m;
						}
						for (int x = 0; x < 10; x++) {
							int[] clone5 = array.clone();
							Arrays.sort(clone5);
							if (Arrays.binarySearch(clone5, x) >= 0) {
								continue;
							} else {
								array[5] = x;
							}
							for (int y = 0; y < 10; y++) {
								int[] clone6 = array.clone();
								Arrays.sort(clone6);
								if (Arrays.binarySearch(clone6, y) >= 0) {
									continue;
								} else {
									array[6] = y;
								}
								for (int z = 0; z < 10; z++) {
									int[] clone7 = array.clone();
									Arrays.sort(clone7);
									if (Arrays.binarySearch(clone7, z) >= 0) {
										continue;
									} else {
										array[7] = z;
									}
									for (int b = 0; b < 10; b++) {
										int[] clone8 = array.clone();
										Arrays.sort(clone8);
										if (Arrays.binarySearch(clone8, b) < 0) {
											array[8] = b;
											times++;
											if (getResult(array)) {
												System.out.println(times);
												return;
											}
											array[8] = -100;
										}
									}
									array[7] = -100;
								}
								array[6] = -100;
							}
							array[5] = -100;
						}
						array[4] = -100;
					}
					array[2] = -100;
				}
				array[1] = -100;
			}
		}

	}

	// 0-A 1-B 2-C 3-D 4-E 5-G 6-L 7-N 8-R 9-T
	private static boolean getResult(int[] array) {
		System.out.println(JSON.toJSON(array));
		int n1 = calc(array, 3, 2, 7, 0, 6, 3);
		int n2 = calc(array, 5, 4, 8, 0, 6, 3);
		int toN = calc(array, 8, 2, 1, 4, 8, 9);
		if (toN == n1 + n2) {
			System.out.println(" " + JSON.toJSON(n1));
			System.out.println("+" + JSON.toJSON(n2));
			System.out.println("=" + JSON.toJSON(toN));
			return true;
		}
		return false;
	}

	private static int calc(int[] input, int i1, int i2, int i3, int i4, int i5, int i6) {
		return calc(input[i1], input[i2], input[i3], input[i4], input[i5], input[i6]);
	}

	private static int calc(int n1, int n2, int n3, int n4, int n5, int n6) {
		return n1 * 100000 + n2 * 10000 + n3 * 1000 + n4 * 100 + n5 * 10 + n6;
	}
}
