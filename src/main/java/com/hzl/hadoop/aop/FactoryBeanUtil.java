package com.hzl.hadoop.aop;

import org.springframework.beans.factory.FactoryBean;

/**
 * description
 *
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
