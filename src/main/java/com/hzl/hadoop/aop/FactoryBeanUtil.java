package com.hzl.hadoop.aop;

import org.springframework.beans.factory.FactoryBean;

/**
 * description
 * https://blog.csdn.net/zknxx/article/details/79572387 通过实现FactoryBean手动创建bean到spring容器，而不需要通过@Service等注解
 * @author hzl 2021/07/26 4:42 PM
 */
public class FactoryBeanUtil implements FactoryBean{


	@Override
	public Object getObject() throws Exception {
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
