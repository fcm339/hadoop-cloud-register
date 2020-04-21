package com.hzl.hadoop.mq.rocketmq.constant;

/**
 * description
 * 消息类型，输入，输出
 *
 * @author hzl 2020/03/25 4:11 PM
 */
public enum Tags {

	TEST1("test-output1"),
	TEST2("test-output2");

	private final String value;

	Tags(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

}
