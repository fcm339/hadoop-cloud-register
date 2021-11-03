package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ApproveGroupEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 审批组
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
public interface ApproveGroupService extends IService<ApproveGroupEntity> {

	PageInfo queryPage(ApproveGroupEntity params, int start, int pageSize);
}

