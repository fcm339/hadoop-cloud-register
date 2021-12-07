package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.WorkflowCharEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 前端生成的流程图，需要转换成开始节点，审批节点，网关节点，结束节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-24 09:34:57
 */
public interface WorkflowCharService extends IService<WorkflowCharEntity> {

	PageInfo queryPage(WorkflowCharEntity params, int start, int pageSize);

	void saveAndConvert(WorkflowCharEntity workflowCharEntity);
}

