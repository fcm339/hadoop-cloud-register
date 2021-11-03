package com.hzl.hadoop.workflow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.workflow.entity.GatewayNodeEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 网关节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
public interface GatewayNodeService extends IService<GatewayNodeEntity> {

	PageInfo queryPage(GatewayNodeEntity params, int start, int pageSize);
}

