package com.hzl.hadoop.workflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.exception.CommonException;
import com.hzl.hadoop.util.JsonUtils;
import com.hzl.hadoop.workflow.convert.FirstCharConver;
import com.hzl.hadoop.workflow.convert.WorkflowCharConver;
import com.hzl.hadoop.workflow.entity.*;
import com.hzl.hadoop.workflow.mapper.*;
import com.hzl.hadoop.workflow.service.WorkflowCharService;
import com.hzl.hadoop.workflow.vo.CharVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service("workflowCharService")
public class WorkflowCharServiceImpl extends ServiceImpl<WorkflowCharMapper, WorkflowCharEntity> implements WorkflowCharService {

	WorkflowCharMapper mapper;

	StartNodeMapper startNodeMapper;

	GatewayNodeMapper gatewayNodeMapper;

	EndNodeMapper endNodeMapper;

	ApproveNodeMapper approveNodeMapper;

	WorkflowCharMapper workflowCharMapper;

	public WorkflowCharServiceImpl(WorkflowCharMapper mapper, StartNodeMapper startNodeMapper, GatewayNodeMapper gatewayNodeMapper,
								   EndNodeMapper endNodeMapper, ApproveNodeMapper approveNodeMapper, WorkflowCharMapper workflowCharMapper) {
		this.mapper = mapper;
		this.startNodeMapper = startNodeMapper;
		this.gatewayNodeMapper = gatewayNodeMapper;
		this.endNodeMapper = endNodeMapper;
		this.approveNodeMapper = approveNodeMapper;
		this.workflowCharMapper = workflowCharMapper;
	}

	@Override
	public PageInfo queryPage(WorkflowCharEntity params, int start, int pageSize) {
		QueryWrapper<WorkflowCharEntity> queryWrapper = new QueryWrapper(params);

		PageInfo<WorkflowCharEntity> pageResult = PageHelper.startPage(start, pageSize).doSelectPageInfo(() -> mapper.selectList(queryWrapper));

		return pageResult;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void saveAndConvert(WorkflowCharEntity workflowCharEntity) {
		//将流程图保存数据库
		if (workflowCharMapper.insert(workflowCharEntity) < 0) {
			throw new CommonException("流程图存储失败");
		}

		//将流程图转换成java对象
		CharVO charVO = JsonUtils.jsonStringToObeject(workflowCharEntity.getCharData(), CharVO.class);

		log.info("CharVO转换后结果{}", charVO);

		//开始转换
		WorkflowCharConver workflowCharConver = new FirstCharConver();

		//转换成开始节点
		StartNodeEntity startNodeEntity = workflowCharConver.converToStartNode(charVO);

		//转换成网关节点
		GatewayNodeEntity gatewayNodeEntity = workflowCharConver.converToGateWayNode(charVO);

		//转换成审批节点
		ApproveNodeEntity approveNodeEntity = workflowCharConver.converToApproveNode(charVO);

		//转换成结束节点
		EndNodeEntity endNodeEntity = workflowCharConver.converToEndNode(charVO);




		if (startNodeMapper.insert(startNodeEntity) < 0) {
			throw new CommonException("开始节点存储失败");
		}

		if (gatewayNodeMapper.insert(gatewayNodeEntity) < 0) {
			throw new CommonException("网关节点存储失败");
		}

		if (approveNodeMapper.insert(approveNodeEntity) < 0) {
			throw new CommonException("审批节点存储失败");
		}

		if (endNodeMapper.insert(endNodeEntity) < 0) {
			throw new CommonException("结束节点存储失败");
		}
	}

}