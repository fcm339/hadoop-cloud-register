package com.hzl.hadoop.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * description
 * 在spring实例化所有bean之前执行，可以用来读取配置元数据,并有可能修改它；如果业务需要，
 * 可以配置多个BeanFactoryPostProcessor的实现类，通过"order"控制执行次序(要实现Ordered接口)。
 * @author hzl 2021/10/18 4:51 PM
 */
public class BeanFactoryPostProcessorUtil  implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
			System.out.println("可以获取bean信息");
	}
}
