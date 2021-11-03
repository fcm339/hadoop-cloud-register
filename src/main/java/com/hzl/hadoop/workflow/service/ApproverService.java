package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.ApproverEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 审批人
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
public interface ApproverService extends IService<ApproverEntity> {

	PageInfo queryPage(ApproverEntity params, int start, int pageSize);
}

