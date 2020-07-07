package com.hzl.hadoop.design.proxy;

/**
 * description
 * 目标对象，被代理对象
 * @author hzl 2020/07/07 4:40 PM
 */
public class TargetObject implements TargetObjectService{

	@Override
	public int test1() {
		System.out.println("被代理对象执行方法");
		return 2;
	}

	@Override
	public boolean test2() {
		return false;
	}
}
