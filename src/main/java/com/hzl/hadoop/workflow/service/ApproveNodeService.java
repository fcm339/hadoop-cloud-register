package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ApproveNodeEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 审批节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
public interface ApproveNodeService extends IService<ApproveNodeEntity> {

	PageInfo queryPage(ApproveNodeEntity params, int start, int pageSize);
}

