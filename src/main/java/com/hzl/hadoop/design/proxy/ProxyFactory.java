package com.hzl.hadoop.design.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description
 * 动态代理类：jdk代理或者叫接口代理，
 * 测试用例：ProxyTest
 * @author hzl 2020/07/07 4:42 PM
 */
@Slf4j
public class ProxyFactory {

	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}

	//给目标对象生成代理对象
	public Object getProxyInstance(){
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						log.info("开始代理");
						//运用反射执行目标对象方法
						Object returnValue = method.invoke(target, args);
						log.info("代理结束");
						return returnValue;
					}
				}
		);
	}
}
