package com.hzl.hadoop.executor;

import com.hzl.hadoop.executor.rejecthandler.RejectBlockHandler;
import com.hzl.hadoop.executor.threadservice.CallableService;
import com.hzl.hadoop.executor.threadservice.RunnableService;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * description
 * 参考https://www.jianshu.com/p/7ab4ae9443b9
 * 线程池工具类demo
 * 线程池主要参数：核心线程数，最多线程数，任务队列，线程工厂，拒绝策略，线程空闲时间（除开核心线程数的线程）
 * 线程池提交任务分为submit（有返回值）和execute(无返回值)
 * FutureTask需要进一步了解
 *
 * @author hzl 2021/08/27 3:38 PM
 */
@Slf4j
public class ExecutorUtils {

	public static void main(String args[]) {
		customExecutor(100);
//		//singleThreadExecutor(100,false);
//		//cacheThreadExecutor(100,true);
//		//scheduleThreadExecutor();
	}

	/**
	 * 固定线程数的线程池，
	 * Executors的实现使用了默认的线程工厂-DefaultThreadFactory。它的实现主要用于创建一个线程，线程的名字为pool-{poolNum}-thread-{threadNum}
	 * PS：在使用submit()的时候一定要注意它的返回对象Future，为了避免任务执行异常被吞掉的问题，我们需要调用Future.get()方法。另外，使用execute()将不会出现这种问题
	 * submit()用于提交一个需要返回果的任务。该方法返回一个Future对象，通过调用这个对象的get()方法，我们就能获得返回结果。get()方法会一直阻塞，直到返回结果返回。
	 * <p>
	 * newFixedThreadPool使用了LinkedBlockingQueue队列，且队列长度为Integer.MAX_VALUE
	 *
	 * @param executeNum 执行次数
	 * @param threadNum  线程数量
	 * @return
	 * @author hzl 2021-08-27 3:57 PM
	 */
	public static void fixExecutor(int threadNum, int executeNum) {
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);

		for (int i = 0; i < executeNum; i++) {
			int finalI = i;
			Future<Long> future = executor.submit(() -> {
				System.out.println(finalI + Thread.currentThread().getName());
				return System.currentTimeMillis();
			});
//			try {
//				System.out.println(future.get());
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.pr
// intStackTrace();
//			}
		}

		executor.shutdown();
	}


	/**
	 * 创建单一线程的线程池
	 * 使用了LinkedBlockingQueue，且队列长度为Integer.MAX_VALUE
	 *
	 * @param executeNum 执行次数
	 * @param isReturn   是否返回
	 * @return
	 * @author hzl 2021-08-31 3:35 PM
	 */

	public static void singleThreadExecutor(int executeNum, boolean isReturn) {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		for (int i = 0; i < executeNum; i++) {
			int finalI = i;
			if (isReturn) {
				Future<Boolean> future = executor.submit(new CallableService(finalI));
				/*try {
					//future.get()会阻塞线程
					System.out.println("结果"+future.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}*/
			} else {
				executor.execute(new RunnableService(finalI));
			}
		}
		executor.shutdown();
	}

	/**
	 * 创建缓存线程池
	 * 核心线程池的长度为0，线程池最大长度为Integer.MAX_VALUE。
	 * 由于本身使用SynchronousQueue作为等待队列的缘故，
	 * 导致往队列里面每插入一个元素，必须等待另一个线程从这个队列删除一个元素。
	 *
	 * @param executeNum 执行次数
	 * @param isReturn   是否返回
	 * @return
	 * @author hzl 2021-08-31 4:44 PM
	 */
	public static void cacheThreadExecutor(int executeNum, boolean isReturn) {
		//使用默认拒绝策略AbortPolicy
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < executeNum; i++) {
			int finalI = i;
			if (isReturn) {
				Future<Boolean> future = executor.submit(new CallableService(finalI));
				/*try {
					//future.get()会阻塞线程
					System.out.println("结果"+future.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}*/
			} else {
				executor.execute(new RunnableService(finalI));
			}
		}
		executor.shutdown();
	}

	/**
	 * 创建定时调度线程池
	 *
	 * @return
	 * @author hzl 2021-08-31 4:44 PM
	 */
	public static void scheduleThreadExecutor() {
		//使用默认拒绝策略AbortPolicy
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

		// 定时调度，每个调度任务会至少等待`period`的时间，
		// 如果任务执行的时间超过`period`，则等待的时间为任务执行的时间
		executor.scheduleAtFixedRate(() -> {
			try {
				Thread.sleep(10000);
				System.out.println(System.currentTimeMillis() / 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 0, 2, TimeUnit.SECONDS);

		// 定时调度，第二个任务执行的时间 = 第一个任务执行时间 + `delay`
		executor.scheduleWithFixedDelay(() -> {
			try {
				Thread.sleep(5000);
				System.out.println(System.currentTimeMillis() / 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 0, 2, TimeUnit.SECONDS);

		// 定时调度，延迟`delay`后执行，且只执行一次
		executor.schedule(() -> System.out.println("5 秒之后执行 schedule"), 5, TimeUnit.SECONDS);
		executor.shutdown();
	}


	/**
	 * 自定义线程池
	 * 1. 等待队列-workQueue
	 * 等待队列是BlockingQueue类型的，理论上只要是它的子类，我们都可以用来作为等待队列。
	 * 同时，jdk内部自带一些阻塞队列，我们来看看大概有哪些。
	 * ArrayBlockingQueue，队列是有界的，基于数组实现的阻塞队列
	 * LinkedBlockingQueue，队列可以有界，也可以无界。基于链表实现的阻塞队列
	 * SynchronousQueue，不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作将一直处于阻塞状态。该队列也是Executors.newCachedThreadPool()的默认队列
	 * PriorityBlockingQueue，带优先级的无界阻塞队列
	 * <p>
	 * 其次，ThreadPoolExecutor留给我们自行处理的方法有3个，它在ThreadPoolExecutor中为空实现（也就是什么都不做）。
	 * <p>
	 * protected void beforeExecute(Thread t, Runnable r) // 任务执行前被调用
	 * protected void afterExecute(Runnable r, Throwable t) // 任务执行后被调用
	 * protected void terminated() // 线程池结束后被调用
	 *
	 * @return
	 * @author hzl 2021-08-27 5:34 PM
	 */

	//设置成单例全局唯一，后面使用SingleExecutor提供的对象
	@Deprecated
	public static ThreadPoolExecutor executor() {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5
				, 10, 60L
				, TimeUnit.SECONDS
				, new ArrayBlockingQueue(10)
				, new ThreadFactoryService()
				, new RejectBlockHandler()) {
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("任务执行前" + t.getName());
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("任务执行后" + Thread.currentThread().getName());
			}

			@Override
			protected void terminated() {
				System.out.println("线程结束后");
			}
		};
		return executor;
	}

	/**
	 * 重写executor
	 *
	 * @return
	 * @author hzl 2021-08-30 5:12 PM
	 */
	private static ThreadPoolExecutor executor(int corePoolSize, int maximumPoolsize, int keepAliveTime, TimeUnit unit, ArrayBlockingQueue<Runnable> arrayBlockingQueue) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10
				, 10, 60L
				, TimeUnit.SECONDS
				, new ArrayBlockingQueue(10)
				, new ThreadFactoryService()
				, new RejectBlockHandler()) {
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("任务执行前" + t.getName());
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("任务执行后" + Thread.currentThread().getName());
			}

			@Override
			protected void terminated() {
				System.out.println("线程结束后");
			}
		};
		return executor;
	}


	/**
	 * 使用自定义线程池完成多线程操作
	 *
	 * @param executeNum 执行次数
	 * @return
	 * @author hzl 2021-08-30 3:12 PM
	 */

	public static void customExecutor(int executeNum) {
		ThreadPoolExecutor executor = ExecutorUtils.executor();
		monitoring(executor);
		for (int i = 0; i < executeNum; i++) {
			int finalI = i;
			Future<Long> future = executor.submit(() -> {
				System.out.println("线程:" + finalI + Thread.currentThread().getName());
				return System.currentTimeMillis();
			});
//			try {
//				System.out.println(future.get());
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			}
		}
		monitoring(executor);
		executor.shutdown();
	}


	/**
	 * ThreadPoolExecutor线程监控工具,只适合当前工具类的自定义线程池方法
	 *
	 * @param executor 线程池对象
	 * @author hzl 2021-08-27 5:43 PM
	 * @return
	 */

	public static void monitoring(ThreadPoolExecutor executor){
		log.info("已经执行或正在执行的任务数"+executor.getTaskCount());
		log.info("已经执行的任务数"+executor.getCompletedTaskCount());
		log.info("线程池曾经创建过的最大线程数"+executor.getLargestPoolSize());
		log.info("获取线程池线程数"+executor.getPoolSize());
		log.info("获取活跃线程数"+executor.getActiveCount());
	}
}
