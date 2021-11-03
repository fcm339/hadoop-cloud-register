package com.hzl.hadoop.workflow.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.mapper.GatewayNodeMapper;
import com.hzl.hadoop.workflow.entity.GatewayNodeEntity;
import com.hzl.hadoop.workflow.service.GatewayNodeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;



@Service("gatewayNodeService")
public class GatewayNodeServiceImpl extends ServiceImpl<GatewayNodeMapper, GatewayNodeEntity> implements GatewayNodeService {

	@Autowired
    GatewayNodeMapper mapper;

    @Override
    public PageInfo queryPage(GatewayNodeEntity params,int start, int pageSize) {
		QueryWrapper<GatewayNodeEntity> queryWrapper = new QueryWrapper(params);

		PageInfo<GatewayNodeEntity> pageResult = PageHelper.startPage(start, pageSize).doSelectPageInfo(() -> mapper.selectList(queryWrapper));

        return pageResult;
    }

}