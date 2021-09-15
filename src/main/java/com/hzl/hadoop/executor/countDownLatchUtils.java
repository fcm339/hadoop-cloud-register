package com.hzl.hadoop.executor;

import java.util.concurrent.CountDownLatch;

/**
 * description
 * CountDownLatch允许一个或多个线程等待其他线程完成操作
 * @author hzl 2021/09/15 7:49 PM
 */
public class countDownLatchUtils {

	static CountDownLatch c = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
				c.countDown();
				System.out.println(2);
				c.countDown();
			}

		}).start();
		c.await();
		System.out.println("3");

	}

}
