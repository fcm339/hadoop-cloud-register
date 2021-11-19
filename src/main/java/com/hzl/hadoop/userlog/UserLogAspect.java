package com.hzl.hadoop.userlog;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.hzl.hadoop.userlog.entity.RequestLogsEntity;
import com.hzl.hadoop.userlog.service.RequestLogsService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

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

	@Autowired
	private RequestLogsService requestLogsService;

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

	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void requestMappingPointCut() {

	}


	@Around("getMappingPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		//MethodSignature signature = (MethodSignature) point.getSignature();
		//Method method = signature.getMethod();
		//获取参数,不能获取对象继承的父类
		Object[] args = point.getArgs();

		//获取请求上下文
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String requestParam = getArgs(args, request);

		log.info("方法参数:{}", requestParam);

		//获取方法返回值
		Object returnResult = point.proceed(args);

		log.info("打印返回结果:{}", returnResult.toString());

		//获取访问人的ip


		String option = request.getMethod();
		String url = request.getRequestURI();
		String ip = getIpAddress(request);

		System.out.println("地址option" + option);

		System.out.println("地址url" + url);
		//用户日志记录,后期换成异步不影响请求性能
		RequestLogsEntity requestLogsEntity = RequestLogsEntity.builder()
				.ip(ip)
				.requestParam(requestParam)
				.url(url)
				.method(option)
				.response(returnResult.toString())
				.build();
		requestLogsService.save(requestLogsEntity);
		//用户日志记录结束
		return returnResult;
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

	/**
	 * 获取请求参数
	 *
	 * @param args
	 * @param request
	 * @return
	 */
	private String getArgs(Object[] args, HttpServletRequest request) {
		String strArgs = StringPool.EMPTY;

		try {
			if (!request.getContentType().contains("multipart/form-data")) {
				strArgs = JSONObject.toJSONString(args);
			}
		} catch (Exception e) {
			try {
				strArgs = Arrays.toString(args);
			} catch (Exception ex) {
				log.warn("解析参数异常", ex);
			}
		}
		return strArgs;
	}
}
