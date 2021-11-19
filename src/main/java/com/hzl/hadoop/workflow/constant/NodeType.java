package com.hzl.hadoop.workflow.constant;

/**
 * description
 * 节点类型
 *
 * @author hzl 2021/11/04 7:32 PM
 */
public enum NodeType {

	START(1),

	GATEWAY(2),

	APPROVE(3),

	END(4);

	private final Integer value;

	NodeType(Integer value) {
		this.value = value;
	}

	public Integer value() {
		return value;
	}
}
