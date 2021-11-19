package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ApproveHistoryGatewayEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 网关审批历史
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-04 14:56:40
 */
public interface ApproveHistoryGatewayService extends IService<ApproveHistoryGatewayEntity> {

	PageInfo queryPage(ApproveHistoryGatewayEntity params, int start, int pageSize);
}

