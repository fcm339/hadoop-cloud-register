package com.hzl.hadoop.security.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description
 * 自定义登陆失败
 * @author hzl 2021/09/10 11:13 AM
 */
@Component
@ConditionalOnProperty(prefix = "httpbasic", name = "isOpen", havingValue = "true", matchIfMissing = false)
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
										AuthenticationException exception) throws IOException {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(JSON.toJSONString(exception.getMessage()));
		//response.getWriter().write(mapper.writeValueAsString(exception.getMessage()));
	}
}
