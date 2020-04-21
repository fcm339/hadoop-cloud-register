package com.hzl.hadoop.mq.rocketmq.provider;

import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description
 *
 * @author hzl 2020/03/25 4:32 PM
 */
public interface ProviderService {

	public void send(String msg) throws Exception;

	/**
	 *
	 *
	 * @param msg 消息内容  tag 标签不同的业务功能用不同的tag，可以写成常量，一个微服务用一个topic
	 * @author hzl 2020-04-20 5:14 PM
	 * @return
	 */
	public <T> void sendWithTags(T msg, String tag) throws Exception ;

	public <T> void sendObject(T msg, String tag) throws Exception ;

	public <T> void sendTransactionalMsg(T msg, int num) throws Exception ;
}
