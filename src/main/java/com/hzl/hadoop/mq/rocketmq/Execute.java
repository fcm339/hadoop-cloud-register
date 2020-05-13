package com.hzl.hadoop.mq.rocketmq;

import com.hzl.hadoop.mq.rocketmq.provider.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * description
 * 服务启动后执行以下方法
 *
 * @author hzl 2020/03/26 11:11 AM
 */
@Slf4j
@Component
public class Execute implements CommandLineRunner {

	@Autowired
	private ProviderService providerService;

	@Override
	public void run(String... args) throws Exception {
		log.info("开始执行rocketmq消息");
		//providerService.send("output1发来的消息");
	}

}
