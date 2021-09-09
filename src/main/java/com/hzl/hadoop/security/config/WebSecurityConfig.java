package com.hzl.hadoop.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * description
 * 参考：https://www.jianshu.com/p/defa75b65a46
 * @author hzl 2021/09/09 4:44 PM
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	//指定密码加密策略
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	@Qualifier("userDetailsServiceImpl")
	UserDetailsService userDetailsService;


	//注入我们自己的AuthenticationProvider
	@Autowired
	@Qualifier("myAuthenticationProvider")
	private AuthenticationProvider provider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// 关闭csrf防护
				.csrf().disable()
				.headers().frameOptions().disable()
				.and();
		http
				//登录处理
				.formLogin() //表单方式，或httpBasic
			    .loginPage("/loginPage")
				.loginProcessingUrl("/form")
				//成功登陆后跳转页面
				.defaultSuccessUrl("/query/pinyin?zw=%E9%BB%84%E5%BF%A0%E4%BA%AE")
				.failureUrl("/loginError")
				.permitAll()
				.and();
		http
				.authorizeRequests() // 授权配置
				//无需权限访问
				.antMatchers("/css/**", "/error404","/register").permitAll()
				.antMatchers("/user/**").hasRole("USER")
				//其他接口需要登录后才能访问
				.anyRequest().authenticated()
				.and();
	}

	//账号密码认证
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}




}
