package com.hzl.hadoop.mq.rocketmq.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * description
 * @author hzl 2020/03/25 3:33 PM
 */
public interface MesseageSource {
	//消息提供者
	@Output("output1")
	MessageChannel output1();

	@Output("output2")
	MessageChannel output2();

	@Output("output3")
	MessageChannel output3();


	//消息接收者
	@Input("input1")
	MessageChannel input1();

	@Input("input2")
	MessageChannel input2();

	@Input("input3")
	MessageChannel input3();

	@Input("input4")
	MessageChannel input4();
}
