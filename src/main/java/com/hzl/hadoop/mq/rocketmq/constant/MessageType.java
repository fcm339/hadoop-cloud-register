package com.hzl.hadoop.mq.rocketmq.constant;

/**
 * description
 * 消息类型，输入，输出
 *
 * @author hzl 2020/03/25 4:11 PM
 */
public enum MessageType {

	INPUT("input"),
	OUTPUT("output");

	private final String value;

	MessageType(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
