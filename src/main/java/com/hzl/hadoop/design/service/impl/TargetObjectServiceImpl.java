package com.hzl.hadoop.design.service.impl;

import com.hzl.hadoop.design.service.TargetObjectService;

/**
 * description
 * 目标对象，被代理对象
 * @author hzl 2020/07/07 4:40 PM
 */
public class TargetObjectServiceImpl implements TargetObjectService {

	@Override
	public int proxyTest() {
		System.out.println("被代理对象执行方法");
		return 2;
	}

	@Override
	public boolean test2() {
		return false;
	}
}
