package com.hzl.hadoop.executor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description
 * 自定义线程工厂Executors的实现使用了默认的线程工厂-DefaultThreadFactory。它的实现主要用于创建一个线程，线程的名字为pool-{poolNum}-thread-{threadNum}
 * privilegedThreadFactory 返回用于创建新线程的线程工厂，这些新线程与当前线程具有相同的权限。
 *
 * @author hzl 2021/08/27 5:50 PM
 */
public class ThreadFactoryService implements ThreadFactory {
	private static final AtomicInteger poolNumber = new AtomicInteger(1);
	private final ThreadGroup group;
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	private final String namePrefix;

	ThreadFactoryService() {
		SecurityManager s = System.getSecurityManager();
		group = (s != null) ? s.getThreadGroup() :
				Thread.currentThread().getThreadGroup();
		namePrefix = "pool-" +
				poolNumber.getAndIncrement() +
				"-thread-";
	}

	@Override
	public Thread newThread(Runnable r) {

		Thread t = new Thread(group, r,
				namePrefix + threadNumber.getAndIncrement(),
				0);
		if (t.isDaemon()) {
			t.setDaemon(false);
		}
		if (t.getPriority() != Thread.NORM_PRIORITY) {
			t.setPriority(Thread.NORM_PRIORITY);
		}
		return t;
	}

}
