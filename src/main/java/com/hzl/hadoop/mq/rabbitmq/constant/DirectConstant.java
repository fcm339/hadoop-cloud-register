package com.hzl.hadoop.mq.rabbitmq.constant;

/**
 * description
 * 交换器类型direct
 * @author hzl 2021/11/09 1:57 PM
 */
public interface DirectConstant {

	/*
	* 队列名称
	* */

	String HOUSE="DIRECT_QUEUE_HOUSE_CODE";


	/**
	 * 交换器类型
	 */

	String EXCHANGE_DEFAULT="amq.direct";

	/**
	 * 路由键
	 * 格式 PROVINCE.CITY.COUNTY
	 */

	String HOUSE_ROUTINT_KEY="DIRECT_QUEUE_HOUSE_CODE";
}
