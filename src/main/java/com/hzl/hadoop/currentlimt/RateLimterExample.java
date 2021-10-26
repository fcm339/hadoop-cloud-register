package com.hzl.hadoop.currentlimt;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * description
 * guava的 RateLimiter限流样例。使用于单机
 * 参考：https://blog.csdn.net/weixin_39793189/article/details/111091753
 * https://blog.csdn.net/zrg523/article/details/82185088
 * https://www.cnblogs.com/sxpujs/p/13246563.html
 * @author hzl 2021/10/26 2:12 PM
 */
public class RateLimterExample {


	/**
	 * 服务端限流常见算法：时间窗口算法，漏桶算法，令牌算法
	 * guava基于令牌算法实现
	 * 令牌桶算法允许一定程度的突发,突发的请求排队等待执行
	 * acquire和tryAcquire区别一个是阻塞等待，另一个是非阻塞，也可以设置等待时间
	 * @author hzl 2021-10-26 2:16 PM
	 * @return 
	 */
	public static void main(String args[]){
		String start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		// 每秒发出5个令牌
		RateLimiter rateLimiter = RateLimiter.create(1.0);

		for (int i = 1; i <= 10; i++) {
			//acquire()用于获取令牌，且是阻塞的方式
			// 请求RateLimiter, 超过permits会被阻塞

			//double waitTime = rateLimiter.acquire(i);
			//Boolean isSuccesss=rateLimiter.tryAcquire(i);
			Boolean isSuccesss=rateLimiter.tryAcquire(i,10000, TimeUnit.MILLISECONDS);
			System.out.println("cutTime=" + System.currentTimeMillis() + " call execute:" + i + " waitTime:" + isSuccesss);
		}
		String end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println("start time:" + start);
		System.out.println("end time:" + end);


	}



}
