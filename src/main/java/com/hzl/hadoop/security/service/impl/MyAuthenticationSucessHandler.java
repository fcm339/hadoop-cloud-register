package com.hzl.hadoop.security.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description
 * 自定义登陆成功后的操作
 * @author hzl 2021/09/10 11:10 AM
 */
@Slf4j
@Component
@ConditionalOnProperty(prefix = "httpbasic", name = "isOpen", havingValue = "true", matchIfMissing = false)
public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest == null){
			redirectStrategy.sendRedirect(request, response, "/query/pinyin?zw=%E9%BB%84%E5%BF%A0%E4%BA%AE");
		}else {
			log.info("自定义重定向地址"+savedRequest.getRedirectUrl());
			redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());
		}
	}
}
