package com.hzl.hadoop.config.mybatis;

import com.hzl.hadoop.constant.DBTypeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author hzl 2020/01/07 9:59 PM
 */

@Aspect
@Component
public class DataSourceAspect {
	@Pointcut("@annotation(com.hzl.hadoop.config.mybatis.DataSource)")
	public void dataSourcePointCut() {

	}

	@Around("dataSourcePointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();

		DataSource dataSource = method.getAnnotation(DataSource.class);
		if (dataSource == null) {
			DynamicDataSource.setDataSource(DBTypeEnum.MASTER.value());
		} else if(DBTypeEnum.MASTER.value().equals(dataSource.name())){
			DynamicDataSource.setDataSource(dataSource.name());
		}else{
			DynamicDataSource.slave();
		}

		try {
			return point.proceed();
		} finally {
			DynamicDataSource.clearDataSource();
		}
	}

}
