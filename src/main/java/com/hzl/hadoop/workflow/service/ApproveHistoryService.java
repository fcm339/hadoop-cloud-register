package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ApproveHistoryEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 审批历史
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
public interface ApproveHistoryService extends IService<ApproveHistoryEntity> {

	PageInfo queryPage(ApproveHistoryEntity params, int start, int pageSize);
}

