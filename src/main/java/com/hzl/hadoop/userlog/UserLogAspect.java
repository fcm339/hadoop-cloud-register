package com.hzl.hadoop.userlog;

import com.hzl.cloud.config.mybatis.DBContextHolder;
import com.hzl.cloud.config.mybatis.DataSource;
import com.hzl.cloud.constant.DBTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 * 用户操作日志
 *
 * @author hzl 2020/01/07 9:59 PM
 */
@Slf4j
@Aspect
@Component
public class UserLogAspect {

	@Value("${hadoop.openMulti: false}")
	private Boolean openMulti;

	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void getMappingPointCut() {

	}

	@Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
	public void deleteMappingPointCut() {

	}

	@Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
	public void putMappingPointCut() {

	}

	@Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public void postMappingPointCut() {

	}


	@Around("getMappingPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		//获取参数,不能获取对象继承的父类
		Object[] args = point.getArgs();
		//获取参数值,不能获取对象继承的父类
		ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
		String[] parameterNames = pnd.getParameterNames(method);
		//封装参数map
		Map<String, Object> paramMap = new HashMap<>(32);
		for (int i = 0; i < parameterNames.length; i++) {
			paramMap.put(parameterNames[i], args[i]);
		}
		log.info("方法参数" + paramMap.toString());

		//获取方法返回值
		Object returnResult = point.proceed(args);
		log.info("打印返回结果" + returnResult.toString());

		GetMapping getMapping = method.getAnnotation(GetMapping.class);
		//获取类上的注解
		RequestMapping requestMapping=point.getTarget().getClass().getAnnotation(RequestMapping.class);
		StringBuilder classPath=new StringBuilder();
		if(requestMapping!=null){
			classPath.append(requestMapping.value().toString());

		}
		//请求地址
		String methodPath= getMapping.value().toString();
		classPath.append(methodPath);

		//操作名称
		String option=getMapping.name();

		//获取访问人的ip
		//获取请求上下文
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		String ip=getIpAddress(request);
		//获取请求上下文结束
		return point.proceed();
	}


	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
