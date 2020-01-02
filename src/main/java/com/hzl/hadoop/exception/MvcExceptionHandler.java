package com.hzl.hadoop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 *	mvc全局异常处理
 * @author hzl 2020/01/02 8:43 PM
 */
@ControllerAdvice
@Slf4j
public class MvcExceptionHandler {

	@ExceptionHandler(value =Exception.class )
	public CommonException exceptionHander(Exception e, HttpServletRequest req){
		log.error("异常"+e.getMessage());
		CommonException commonException = new CommonException(e.getMessage());
		return commonException;
	}
}
