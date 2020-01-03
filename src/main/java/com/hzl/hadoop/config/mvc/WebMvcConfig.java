package com.hzl.hadoop.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * description
 *
 * @author hzl 2020/01/03 11:25 AM
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{
	
	/**
	 * <p>
	 * 配置拦截器
	 * </p>
	 * 
	 * @author hzl 2020/01/03 11:33 AM
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
	}
    /**
     * <p>
     * 配置跨域路径映射
     * </p>
     * 
     * @author hzl 2020/01/03 11:34 AM
     */
	@Override
	protected void addCorsMappings(CorsRegistry registry) {
	}

	/**
	 * <p>
	 * 配置格式化器
	 * </p>
	 * 
	 * @author hzl 2020/01/03 11:34 AM
	 */
	@Override
	protected void addFormatters(FormatterRegistry registry) {
	}

	/**
	 * <p>
	 * 配置视图控制器映射
	 * </p>
	 * 
	 * @author hzl 2020/01/03 12:37 PM
	 */
	@Override
	protected void addViewControllers(ViewControllerRegistry registry) {
	}
}
