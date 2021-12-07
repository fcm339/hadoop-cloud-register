package com.hzl.hadoop.workflow.convert;

import com.hzl.hadoop.workflow.entity.ApproveNodeEntity;
import com.hzl.hadoop.workflow.entity.EndNodeEntity;
import com.hzl.hadoop.workflow.entity.GatewayNodeEntity;
import com.hzl.hadoop.workflow.entity.StartNodeEntity;
import com.hzl.hadoop.workflow.vo.CharVO;

/**
 * description
 *
 * @author hzl 2021/11/24 5:07 PM
 */
public class FirstCharConver implements WorkflowCharConver<CharVO> {

//TODO
	@Override
	public StartNodeEntity converToStartNode(CharVO charVO) {
//		StartNodeEntity.builder()
//				.approverGroupId()
//				.approverId()
//				.globalListen()
//				.isMailNotify()
//				.nextNodeId()
//				.nextNodeType()
//				.
//				.build();

		return null;
	}

	@Override
	public GatewayNodeEntity converToGateWayNode(CharVO charVO) {
		return null;
	}

	@Override
	public ApproveNodeEntity converToApproveNode(CharVO charVO) {
		return null;
	}

	@Override
	public EndNodeEntity converToEndNode(CharVO charVO) {
		return null;
	}
}
