package com.hzl.hadoop.executor.threadservice;

import com.hzl.hadoop.exception.CommonException;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * description
 *在很多场景下，我们通过线程来异步执行任务之后，希望获取到任务的执行结果。比如RPC框架中，需要异步获取任务返回值。这种情况下，Runnable无法获取返回值就无法满足需求了，因此Callable就出现了。
 Callable也是一个接口，也只有一个call()方法，不同的是Callable的call()方法有是有返回值的，返回值的类型是一个泛型，泛型由创建Callable对象时指定。
 public interface Callable<V> {
 V call() throws Exception;
 }

 * @author hzl 2021/08/27 5:28 PM
 */
@Slf4j
public class CallableService implements Callable<Boolean> {

	private int num;

	public CallableService(int num) {
		this.num = num;
	}
	public CallableService() {

	}


	@Override
	public Boolean call() throws Exception {
		log.info("执行次数"+num +Thread.currentThread().getName());
		if(num==3){
			//用于测试submit后，Future不调用get无法捕获异常
			throw new CommonException("异常");
		}
		return true;
	}
}
