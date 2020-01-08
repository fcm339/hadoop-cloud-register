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
 * 通过切片读取注解@DataSource，在建立初始化连接前指定当前线程的数据源
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
			DBContextHolder.setDataSource(DBTypeEnum.MASTER.value());
		} else if(DBTypeEnum.MASTER.value().equals(dataSource.name())){
			DBContextHolder.setDataSource(dataSource.name());
		}else{
			DBContextHolder.setDataSource(dataSource.name());
		}

		try {
			return point.proceed();
		} finally {
			DBContextHolder.clearDataSource();
		}
	}

}
