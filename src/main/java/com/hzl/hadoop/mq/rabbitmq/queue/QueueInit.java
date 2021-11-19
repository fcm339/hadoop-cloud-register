package com.hzl.hadoop.mq.rabbitmq.queue;

import com.hzl.hadoop.mq.rabbitmq.constant.DirectConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 * 声明队列
 *
 * @author hzl 2021/11/09 2:03 PM
 */
@Configuration
public class QueueInit {


	@Bean
	public Queue directHouseQueue() {
		return new Queue(DirectConstant.HOUSE);
	}


}
