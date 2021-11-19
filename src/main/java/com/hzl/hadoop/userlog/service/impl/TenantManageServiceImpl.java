package com.hzl.hadoop.userlog.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.userlog.mapper.TenantManageMapper;
import com.hzl.hadoop.userlog.entity.TenantManageEntity;
import com.hzl.hadoop.userlog.service.TenantManageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;



@Service("tenantManageService")
public class TenantManageServiceImpl extends ServiceImpl<TenantManageMapper, TenantManageEntity> implements TenantManageService {

	@Autowired
    TenantManageMapper mapper;

    @Override
    public PageInfo queryPage(TenantManageEntity params,int start, int pageSize) {
		QueryWrapper<TenantManageEntity> queryWrapper = new QueryWrapper(params);

		PageInfo<TenantManageEntity> pageResult = PageHelper.startPage(start, pageSize).doSelectPageInfo(() -> mapper.selectList(queryWrapper));

        return pageResult;
    }

}