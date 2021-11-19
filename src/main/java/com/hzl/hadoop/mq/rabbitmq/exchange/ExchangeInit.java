package com.hzl.hadoop.mq.rabbitmq.exchange;

import com.hzl.hadoop.mq.rabbitmq.constant.DirectConstant;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 * 声明交换机
 *
 * @author hzl 2021/11/09 2:08 PM
 */
@Configuration
public class ExchangeInit {

	@Bean
	public DirectExchange directHouseExchange() {
		return new DirectExchange(DirectConstant.EXCHANGE_DEFAULT);
	}
}
