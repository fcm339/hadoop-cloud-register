package com.hzl.hadoop.workflow.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * description
 * 流程启动参数
 * @author hzl 2021/11/04 1:09 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartWorkFlowVO {

	/**
	 * 启动节点的编号
	 */
	@NotNull(message = "启动节点编号不能为空")
	String startNodeNum;


	/**
	 * 流程变量
	 */
	String processVaribale;

	/**
	 * 当前提交人
	 */
	@NotNull(message = "当前提交人编号不能为空")
	String submitPerson;


}
