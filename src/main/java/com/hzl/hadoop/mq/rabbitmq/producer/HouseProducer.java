package com.hzl.hadoop.mq.rabbitmq.producer;

import com.hzl.hadoop.mq.rabbitmq.constant.DirectConstant;
import com.hzl.hadoop.mq.rabbitmq.message.HouseCode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author hzl 2021/11/09 2:22 PM
 */
@Component
public class HouseProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void publish(){
		rabbitTemplate.convertAndSend(DirectConstant.EXCHANGE_DEFAULT,DirectConstant.HOUSE_ROUTINT_KEY,new HouseCode("11"));
	}
}
