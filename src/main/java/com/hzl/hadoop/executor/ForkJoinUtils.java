package com.hzl.hadoop.executor;

import com.hzl.hadoop.executor.forkjoin.RecursiveTaskUtils;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * description
 * 参考https://zhuanlan.zhihu.com/p/190170283
 * @author hzl 2021/09/15 5:32 PM
 */
public class ForkJoinUtils {

	public static void main(String[] args) throws Exception {
		// 创建2000个随机数组成的数组:
		int[] array = new int[2000];
		int expectedSum = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = random();
			expectedSum += array[i];
		}
		System.out.println("Expected sum: " + expectedSum);
		// fork/join:
		RecursiveTaskUtils task = new RecursiveTaskUtils(0,  array.length,array);
		long startTime = System.currentTimeMillis();
		Integer result = ForkJoinPool.commonPool().invoke(task);
		long endTime = System.currentTimeMillis();
		System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
	}

	static Random random = new Random(0);

	static int random() {
		return random.nextInt(1000);
	}

}
