package com.hzl.hadoop.executor;

import java.util.concurrent.*;

/**
 * description
 * 参考https://www.jianshu.com/p/7ab4ae9443b9
 * 线程池工具类demo
 * 线程池主要参数：核心线程数，最多线程数，任务队列，线程工厂，拒绝策略，线程空闲时间（除开核心线程数的线程）
 * 线程池提交任务分为submit（有返回值）和execute(无返回值)
 * FutureTask需要进一步了解
 * @author hzl 2021/08/27 3:38 PM
 */
public class ExecutorUtil {
	
	public static  void main(String args[]){
		fixExecutor(5,100);
	}
	/**
	 * 固定线程数的线程池，
	 * Executors的实现使用了默认的线程工厂-DefaultThreadFactory。它的实现主要用于创建一个线程，线程的名字为pool-{poolNum}-thread-{threadNum}
	 * PS：在使用submit()的时候一定要注意它的返回对象Future，为了避免任务执行异常被吞掉的问题，我们需要调用Future.get()方法。另外，使用execute()将不会出现这种问题
	 * submit()用于提交一个需要返回果的任务。该方法返回一个Future对象，通过调用这个对象的get()方法，我们就能获得返回结果。get()方法会一直阻塞，直到返回结果返回。
	 * @param executeNum 执行次数
	 * @param threadNum 线程数量
	 * @author hzl 2021-08-27 3:57 PM
	 * @return 
	 */
	public static void fixExecutor(int threadNum,int executeNum){
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);

		for(int i=0;i<executeNum;i++){
			int finalI = i;
			Future<Long> future=executor.submit(()->{
				System.out.println(finalI +Thread.currentThread().getName());
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
	 * 自定义线程池
	 * 1. 等待队列-workQueue
			 等待队列是BlockingQueue类型的，理论上只要是它的子类，我们都可以用来作为等待队列。
			 同时，jdk内部自带一些阻塞队列，我们来看看大概有哪些。
			 ArrayBlockingQueue，队列是有界的，基于数组实现的阻塞队列
			 LinkedBlockingQueue，队列可以有界，也可以无界。基于链表实现的阻塞队列
			 SynchronousQueue，不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作将一直处于阻塞状态。该队列也是Executors.newCachedThreadPool()的默认队列
			 PriorityBlockingQueue，带优先级的无界阻塞队列

	 其次，ThreadPoolExecutor留给我们自行处理的方法有3个，它在ThreadPoolExecutor中为空实现（也就是什么都不做）。

			 protected void beforeExecute(Thread t, Runnable r) // 任务执行前被调用
			 protected void afterExecute(Runnable r, Throwable t) // 任务执行后被调用
			 protected void terminated() // 线程池结束后被调用

	 * @author hzl 2021-08-27 5:34 PM
	 * @return
	 */

	private static ThreadPoolExecutor executor(){
		 ThreadPoolExecutor executor = new ThreadPoolExecutor(10
				 ,10,60L
				 , TimeUnit.SECONDS
				 ,new ArrayBlockingQueue(10)
				 ,new ThreadFactoryService()
				 ,new RejectHandler()){
			 @Override protected void beforeExecute(Thread t, Runnable r) {
				 System.out.println("beforeExecute is called");
			 }
			 @Override protected void afterExecute(Runnable r, Throwable t) {
				 System.out.println("afterExecute is called");
			 }
			 @Override protected void terminated() {
				 System.out.println("terminated is called");
			 }
		 };
		return executor;
	}



	
	/**
	 * 线程监控工具
	 *
	 * @param null
	 * @author hzl 2021-08-27 5:43 PM
	 * @return 
	 */
}
