package com.hzl.hadoop.mq.rocketmq.customer.impl;

import com.hzl.hadoop.mq.rocketmq.customer.CustomerService;
import com.hzl.hadoop.mq.rocketmq.entity.Foo;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * description
 *
 * @author hzl 2020/03/25 4:26 PM
 */
public class MesseageSourceImpl implements CustomerService {


	@Override
	@StreamListener("input1")
	public void receiveInput1(String receiveMsg) {
		System.out.println("input1 receive: " + receiveMsg);
	}

	@Override
	@StreamListener("input2")
	public void receiveInput2(String receiveMsg) {
		System.out.println("input2 receive: " + receiveMsg);
	}

	@Override
	@StreamListener("input3")
	public void receiveInput3(@Payload Foo foo) {
		System.out.println("input3 receive: " + foo);
	}

	@Override
	@StreamListener("input4")
	public void receiveTransactionalMsg(String transactionMsg) {
		System.out.println("input4 receive transaction msg: " + transactionMsg);
	}
}
