package com.kpztech.practice.algorithm.bytedance;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 2个有序数组，合并后输出新数组
 * 如：
 * a = {1,3,5,6,8}
 * b = {2,4,4,9,16}
 * 输出：
 * c = {1,2,3,4,4,5,6,9,16}
 */
public class BD1 {
	@Test
	public void test() {
		int[] a = {1, 3, 5, 6, 8};
		int[] b = {2, 4, 4, 9, 16};
		int[] c = concat(a, b);
		System.out.println(JSON.toJSONString(c));
	}

	private int[] concat(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i1 = 0;
		int i2 = 0;
		for (int i = 0; i < c.length; i++) {
			if(i1 == a.length){
				c[i] = b[i2];
				i2++;
				continue;
			}

			if(i2 == b.length){
				c[i] = a[i1];
				i1++;
				continue;
			}


			if (a[i1] > b[i2]) {
				c[i] = b[i2];
				i2++;
			} else {
				c[i] = a[i1];
				i1++;
			}
		}


		return c;
	}

}
