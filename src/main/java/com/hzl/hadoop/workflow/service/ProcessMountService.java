package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ProcessMountEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 流程挂载
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:13
 */
public interface ProcessMountService extends IService<ProcessMountEntity> {

	PageInfo queryPage(ProcessMountEntity params, int start, int pageSize);
}

