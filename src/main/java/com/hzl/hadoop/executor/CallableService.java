package com.hzl.hadoop.executor;

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
public class CallableService implements Callable {

	@Override
	public Object call() throws Exception {

		return null;
	}
}
