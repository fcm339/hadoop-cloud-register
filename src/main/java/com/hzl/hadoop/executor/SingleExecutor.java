package com.hzl.hadoop.executor;

import com.hzl.hadoop.design.single.StaticSingle;
import com.hzl.hadoop.executor.rejecthandler.RejectBlockHandler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description
 * 线程池对象设置成单利，全局唯一
 * @author hzl 2021/09/15 6:07 PM
 */
public class SingleExecutor {

	private static class StaticSingleInstance {

		private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5
				, 10, 60L
				, TimeUnit.SECONDS
				, new ArrayBlockingQueue(10)
				, new ThreadFactoryService()
				, new RejectBlockHandler()) {
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				//System.out.println("任务执行前" + t.getName());
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				//System.out.println("任务执行后" + Thread.currentThread().getName());
			}

			@Override
			protected void terminated() {
				System.out.println("线程池结束");
			}
		};
	}

	private SingleExecutor() {

	}

	public static ThreadPoolExecutor getInstance() {
		return SingleExecutor.StaticSingleInstance.executor;
	}

}
