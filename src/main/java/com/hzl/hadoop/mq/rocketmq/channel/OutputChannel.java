package com.hzl.hadoop.mq.rocketmq.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * description
 *
 * @author hzl 2020/04/17 3:04 PM
 */
public interface OutputChannel {

	//消息提供者
	@Output("output1")
	MessageChannel output1();

	@Output("output2")
	MessageChannel output2();

	@Output("output3")
	MessageChannel output3();

}
