package com.hzl.hadoop.mq.rocketmq.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * description
 *
 * @author hzl 2020/04/17 3:04 PM
 */
public interface InputChannel {


	//消息接收者
	@Input("input1")
	MessageChannel input1();

//	@Input("input2")
//	MessageChannel input2();
//
//	@Input("input3")
//	MessageChannel input3();
//
//	@Input("input4")
//	MessageChannel input4();
}
