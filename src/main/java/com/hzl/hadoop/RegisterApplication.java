package com.hzl.hadoop;

import com.hzl.hadoop.mq.rocketmq.channel.InputChannel;
import com.hzl.hadoop.mq.rocketmq.channel.OutputChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * description
 * 注册中心http://127.0.0.1:8848/nacos/index.html
 * 启动nacos命令：sh startup.sh -m standalone
 * 默认密码：nacos/nacos
 * druid的管理界面http://localhost:8888/druid/login.html
 * 账号密码：admin,admin
 *
 * @author hzl 2019/12/27 3:44 PM
 */

@EnableDiscoveryClient
@SpringBootApplication
@EnableWebMvc
public class RegisterApplication {

	public static void main(String args[]) {
		SpringApplication.run(RegisterApplication.class, args);
	}
}







