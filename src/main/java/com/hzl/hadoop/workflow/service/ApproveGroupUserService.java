package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ApproveGroupUserEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 审批组人员
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
public interface ApproveGroupUserService extends IService<ApproveGroupUserEntity> {

	PageInfo queryPage(ApproveGroupUserEntity params, int start, int pageSize);
}

