package com.hzl.hadoop.design.single;

/**
 * description
 * 静态内部类方式实现单例：线程安全的
 * 延迟加载， java中的内部类是延时加载的，只有在第一次使用时加载；不使用就不加载；
 * @author hzl 2021/09/02 1:50 PM
 */
public class StaticSingle {

	private static class StaticSingleInstance {
		private static StaticSingle staticSingle = new StaticSingle();
	}

	private StaticSingle() {

	}

	public static StaticSingle getInstance() {
		return StaticSingleInstance.staticSingle;
	}
}
