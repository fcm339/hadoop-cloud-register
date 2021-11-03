package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.StartNodeEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 开始节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
public interface StartNodeService extends IService<StartNodeEntity> {

	PageInfo queryPage(StartNodeEntity params, int start, int pageSize);
}

