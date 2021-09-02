package com.hzl.hadoop.design.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description
 *
 *  饿汉，懒汉，内部类方式的单例都会被反射机制破解，例如对于饿汉式，可以通过反射获得该类的构造器直接构造对象。可以通过枚举解决
 * 	如何选用：

 		-单例对象 占用资源少，不需要延时加载，枚举 好于 饿汉

 		-单例对象 占用资源多，需要延时加载，静态内部类 好于 懒汉式
 *
 * @author hzl 2021/09/02 1:06 PM
 */
public class LazyTest {

	//线程安全
	public static void hungryfixExecutor(int threadNum, int executeNum) {
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);

		for (int i = 0; i < executeNum; i++) {
			int finalI = i;
			executor.execute(() -> {
				System.out.println(finalI + Thread.currentThread().getName()+"hashcode:"+ HungrySingle.getInstance().hashCode());
			});

		}
		executor.shutdown();
	}

	//非线程安全
	public static void lazyfixExecutor(int threadNum, int executeNum) {
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);

		for (int i = 0; i < executeNum; i++) {
			int finalI = i;
			executor.execute(() -> {
				System.out.println(finalI + Thread.currentThread().getName()+"hashcode:"+ LazySingle.getInstance().hashCode());
			});

		}
		executor.shutdown();
	}

	//线程安全
	public static void securityLazyfixExecutor(int threadNum, int executeNum) {
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);

		for (int i = 0; i < executeNum; i++) {
			int finalI = i;
			executor.execute(() -> {
				System.out.println(finalI + Thread.currentThread().getName()+"hashcode:"+ SecurityLazySingle.getSecurityInstance().hashCode());
			});

		}
		executor.shutdown();
	}

	//线程安全，延迟加载
	public static void staticfixExecutor(int threadNum, int executeNum) {
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);

		for (int i = 0; i < executeNum; i++) {
			int finalI = i;
			executor.execute(() -> {
				System.out.println(finalI + Thread.currentThread().getName()+"hashcode:"+ StaticSingle.getInstance().hashCode());
			});

		}
		executor.shutdown();
	}

	//线程安全，非延迟加载
	public static void enumfixExecutor(int threadNum, int executeNum) {
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);

		for (int i = 0; i < executeNum; i++) {
			executor.execute(() -> {
				System.out.println(EnumSingle.SINGLETON.getInstance().hashCode());
			});

		}
		executor.shutdown();
	}


	public static void main(String args[]){

		//饿汉模式
		//hungryfixExecutor(3,9);

		//懒汉模式
		//lazyfixExecutor(3,9);

		//懒汉模式，线程安全
		//securityLazyfixExecutor(3,9);

		//静态内部类方式
		//staticfixExecutor(3,9);

		//枚举类单例
		enumfixExecutor(3,9);
	}
}
