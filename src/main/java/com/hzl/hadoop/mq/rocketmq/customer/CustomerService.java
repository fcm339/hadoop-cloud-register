package com.hzl.hadoop.mq.rocketmq.customer;

import com.hzl.hadoop.mq.rocketmq.entity.Foo;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * description
 *
 * @author hzl 2020/03/25 4:28 PM
 */
public interface CustomerService {

	void receiveInput1(String receiveMsg);


	void receiveInput2(String receiveMsg);


	void receiveInput3(@Payload Foo foo);

	void receiveTransactionalMsg(String transactionMsg);


}
