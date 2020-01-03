package com.hzl.hadoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description
 *注册中心http://127.0.0.1:8848/nacos/index.html
 * 启动nacos命令：sh startup.sh -m standalone
 * 默认密码：nacos/nacos
 * @author hzl 2019/12/27 3:44 PM
 */

@EnableDiscoveryClient
@SpringBootApplication
public class RegisterApplication {

	public static void main(String args[]) {
		SpringApplication.run(RegisterApplication.class, args);
	}
}
