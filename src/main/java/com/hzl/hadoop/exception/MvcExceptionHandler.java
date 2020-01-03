package com.hzl.hadoop.exception;

import com.hzl.hadoop.constant.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *	mvc全局异常处理
 * @author hzl 2020/01/02 8:43 PM
 */
@ControllerAdvice
@Slf4j
public class MvcExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value =Exception.class )
	public Map exceptionHander(Exception e, HttpServletRequest req){
		log.error("异常"+e.getMessage());
		HashMap map=new HashMap();
		map.put("code", ExceptionCode.ERROR);
		map.put("message",e.getMessage());
		return map;
	}
}
