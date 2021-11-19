package com.hzl.hadoop.userlog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.userlog.entity.TenantManageEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 租户管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-19 16:18:12
 */
public interface TenantManageService extends IService<TenantManageEntity> {

	PageInfo queryPage(TenantManageEntity params, int start, int pageSize);
}

