package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ProcessVariableEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 流程变量
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:13
 */
public interface ProcessVariableService extends IService<ProcessVariableEntity> {

	PageInfo queryPage(ProcessVariableEntity params, int start, int pageSize);
}

