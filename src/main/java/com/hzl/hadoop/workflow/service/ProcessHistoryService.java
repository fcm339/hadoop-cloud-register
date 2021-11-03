package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ProcessHistoryEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 流程记录
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
public interface ProcessHistoryService extends IService<ProcessHistoryEntity> {

	PageInfo queryPage(ProcessHistoryEntity params, int start, int pageSize);
}

