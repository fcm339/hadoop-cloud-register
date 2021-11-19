package com.hzl.hadoop.workflow.constant;

/**
 * description
 * 审批动作常量
 *
 * @author hzl 2021/11/04 7:27 PM
 */
public enum ApproveActionConstant {

	//同意
	AGREE(1L),

	//拒绝
	REJECT(2L),

	//跳过
	SKIP(3L),

	//转交
	TURN_ORVER(4L);

	private final Long value;

	ApproveActionConstant(Long value) {
		this.value = value;
	}

	public Long value() {
		return value;
	}
}



