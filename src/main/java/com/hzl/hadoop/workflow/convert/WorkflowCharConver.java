package com.hzl.hadoop.workflow.convert;

import com.hzl.hadoop.workflow.entity.ApproveNodeEntity;
import com.hzl.hadoop.workflow.entity.EndNodeEntity;
import com.hzl.hadoop.workflow.entity.GatewayNodeEntity;
import com.hzl.hadoop.workflow.entity.StartNodeEntity;

/**
 * description
 * CharVO 转换成开始节点,网关节点,审批节点,结束节点
 * T为需要转换的类
 * @author hzl 2021/11/24 4:59 PM
 */
public interface WorkflowCharConver<T> {

	/**
	 * <p>
	 * 转换成开始节点
	 * </p>
	 *
	 * @author hzl 2021/11/24 5:09 PM
	 */
	StartNodeEntity converToStartNode(T t);

	/**
	 * <p>
	 * 网关节点
	 * </p>
	 *
	 * @author hzl 2021/11/24 5:09 PM
	 */
	GatewayNodeEntity converToGateWayNode(T t);

	/**
	 * <p>
	 * 审批节点
	 * </p>
	 *
	 * @author hzl 2021/11/24 5:09 PM
	 */
	ApproveNodeEntity converToApproveNode(T t);

	/**
	 * <p>
	 * 结束节点
	 * </p>
	 *
	 * @author hzl 2021/11/24 5:09 PM
	 */
	EndNodeEntity converToEndNode(T t);

}
