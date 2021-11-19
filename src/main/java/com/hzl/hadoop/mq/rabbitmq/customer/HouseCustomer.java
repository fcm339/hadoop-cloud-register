package com.hzl.hadoop.mq.rabbitmq.customer;

import com.hzl.hadoop.mq.rabbitmq.message.HouseCode;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.hzl.hadoop.mq.rabbitmq.constant.DirectConstant.HOUSE;

/**
 * description
 *
 * @author hzl 2021/11/09 2:39 PM
 */
@Component
public class HouseCustomer{

	//@RabbitListener(queues =HOUSE)
	public void displayMail(HouseCode houseCode){
		System.out.println("directqueue1队列监听器1号收到消息"+houseCode.toString());
	}
}
