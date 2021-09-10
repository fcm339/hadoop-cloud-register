package com.hzl.hadoop.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 * 接口角色权限控制
 * @author hzl 2021/09/10 11:53 AM
 */
public interface RoleOauthService {

	Boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
