package com.kpztech.practice.base.java;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 从一列单词中选出以字母a开头的单词，按字母排序后返回前3个。
 */
public class StreamTest {
	@Test
	public void test() {
		List<String> list = Lists.newArrayList("are", "where", "advance", "anvato", "java", "abc");
		System.out.println(list);

		List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> unOrdered = intList.stream().unordered().collect(Collectors.toList());
		System.out.println(unOrdered);

		List<String> result = list.stream().filter(x -> x.startsWith("a")).sorted().limit(3).collect(Collectors.toList());
		System.out.println(result);
	}

	@Test
	public void test1(){
		LongAdder data = new LongAdder();
		IntStream.range(0,2).forEach(i ->{
			new Thread(() -> {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				IntStream.range(0,100).forEach(x -> {
					data.increment();
				});
			}).start();
		});
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(data.sum());
	}

	@Test
	public void test2(){
		int i=0;
		System.out.println(++i);
		System.out.println(i++);
	}
}
