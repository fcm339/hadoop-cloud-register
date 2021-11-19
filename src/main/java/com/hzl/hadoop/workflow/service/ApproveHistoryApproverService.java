package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ApproveHistoryApproverEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 审批节点审批历史
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-04 14:56:39
 */
public interface ApproveHistoryApproverService extends IService<ApproveHistoryApproverEntity> {

	PageInfo queryPage(ApproveHistoryApproverEntity params, int start, int pageSize);
}

