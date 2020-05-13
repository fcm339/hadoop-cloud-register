package com.hzl.hadoop.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * description
 * 参考资料
 * https://blog.csdn.net/weixin_38111957/article/details/86352677
 * https://www.cnblogs.com/yemengshen/p/11561379.html
 * @author hzl 2020/05/13 9:20 PM
 */
@Component
public class WebSocketConfig {

	/**
	 * ServerEndpointExporter 作用
	 *
	 * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket endpoint
	 *
	 * @return
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

}
