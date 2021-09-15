package com.hzl.hadoop.executor.threadservice;

import com.hzl.hadoop.exception.CommonException;

import java.util.function.Supplier;

/**
 * description
 * 供方法SupplyAsync执行
 * @author hzl 2021/09/15 6:27 PM
 */
public class SupplyAsyncService implements Supplier<Boolean> {

	private int num;

	public SupplyAsyncService(int num) {
		this.num = num;
	}


	public Boolean run() {
		//业务逻辑
		System.out.println("执行次数"+num +Thread.currentThread().getName());
		if(num==3){
			//用于测试submit后，Future不调用get无法捕获异常
			throw new CommonException("异常");
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean get() {
		return run();
	}
}
