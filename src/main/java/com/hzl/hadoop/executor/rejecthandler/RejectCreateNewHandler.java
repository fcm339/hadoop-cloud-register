package com.hzl.hadoop.executor.rejecthandler;

import com.hzl.hadoop.exception.CommonException;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * description
 *
 * @author hzl 2021/08/30 8:49 PM
 */
@Slf4j
public class RejectCreateNewHandler implements RejectedExecutionHandler {

	/**
	 * 自定义拒绝策略的目的是，有界阻塞队列情况下，被拒绝的线程依然执行，而不是像默认的一样报错，或者不执行
	 * 只要资源充足，就创建新线程，去执行被拒绝的线程
	 * @author hzl 2021-08-30 8:16 PM
	 * @return
	 */
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		log.info("有线程被拒绝");
		//1第一种策略只要资源充足，就创建新线程，去执行被拒绝的线程
		//缺点：线程若是无限制的创建，可能会导致内存占用过多而产生OOM，并且会造成cpu过度切换。
		try {
			final Thread t = new Thread(r, "临时任务线程");
			t.start();
		}catch (Throwable e){
			throw new CommonException("自定义线程策略只要资源足够就创建新的线程执行----线程创建失败");
		}
		//第二种：或者什么也不执行，把执行失败的查询出来重新执行一遍

		//第三种：多有界阻塞队列使用put操作，也就是当队列满了以后阻塞插入，等有多余空间了在停止阻塞，并插入数据到队列参考：https://blog.csdn.net/yamadeee/article/details/100181893
		/*try {
			log.info("有线程被拒绝将被拒绝的线程通过put阻塞方式插入，阻塞队列");
			executor.getQueue().put(r);
			log.info("有线程被拒绝将被拒绝的线程通过put阻塞方式插入，阻塞队列---插入完成");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}



}
