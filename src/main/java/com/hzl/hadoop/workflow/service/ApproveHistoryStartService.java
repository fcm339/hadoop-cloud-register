package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ApproveHistoryStartEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 开始审批历史
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-04 14:56:40
 */
public interface ApproveHistoryStartService extends IService<ApproveHistoryStartEntity> {

	PageInfo queryPage(ApproveHistoryStartEntity params, int start, int pageSize);
}

