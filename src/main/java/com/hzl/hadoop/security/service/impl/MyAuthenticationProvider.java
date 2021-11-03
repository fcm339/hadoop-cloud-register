package com.hzl.hadoop.security.service.impl;

import com.hzl.hadoop.exception.CommonException;
import com.hzl.hadoop.security.dataobject.SysUser;
import com.hzl.hadoop.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * description
 *
 * @author hzl 2021/09/09 8:32 PM
 */
@Component
@ConditionalOnProperty(prefix = "httpbasic", name = "isOpen", havingValue = "true", matchIfMissing = false)
public class MyAuthenticationProvider implements AuthenticationProvider {

	/**
	 * 注入我们自己定义的用户信息获取对象
	 */
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
		String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；
		// 这里构建来判断用户是否存在和密码是否正确
		UserDetails userInfo = userDetailsService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；
		if (userInfo == null) {
			throw new BadCredentialsException("用户名不存在");
		}
		System.out.println("密码1"+password);
		System.out.println("密码2"+userInfo.getPassword());
		boolean flag = passwordEncoder.matches(password,userInfo.getPassword());
		System.out.println("密码对比"+flag);

		if (!flag) {
			throw new CommonException("密码不正确");
		}
		Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
		// 构建返回的用户登录成功的token
		return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
		//return new UsernamePasswordAuthenticationToken(userInfo, null,authorities);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		// 这里直接改成retrun true;表示是支持这个执行
		return true;
	}
}
