package com.hzl.hadoop.mq.rabbitmq.message;

import java.io.Serializable;

/**
 * description
 *
 * @author hzl 2021/11/09 2:29 PM
 */
public class HouseCode implements Serializable {

	private static final long serialVersionUID = 1L;


	private String houseCode;

	public HouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	@Override
	public String toString() {
		return "HouseCode{" +
				"houseCode='" + houseCode + '\'' +
				'}';
	}
}
