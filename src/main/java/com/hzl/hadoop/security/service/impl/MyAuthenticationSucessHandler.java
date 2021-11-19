package com.hzl.hadoop.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description
 * 自定义登陆成功后的操作
 *
 * @author hzl 2021/09/10 11:10 AM
 */
@Slf4j
@Component
public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest == null) {
			redirectStrategy.sendRedirect(request, response, "/loginPage");
		} else {
			log.info("自定义重定向地址" + savedRequest.getRedirectUrl());
			redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());
		}
	}
}
