package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.EndNodeEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 结束节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:13
 */
public interface EndNodeService extends IService<EndNodeEntity> {

	PageInfo queryPage(EndNodeEntity params, int start, int pageSize);
}

