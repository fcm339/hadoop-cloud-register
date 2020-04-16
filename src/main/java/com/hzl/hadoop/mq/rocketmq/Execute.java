package com.hzl.hadoop.mq.rocketmq;

import lombok.extern.slf4j.Slf4j;
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

	@Override
	public void run(String... args) throws Exception {
		log.info("开始执行");
	}

}
