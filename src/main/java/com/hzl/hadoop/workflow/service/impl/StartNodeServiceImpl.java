package com.hzl.hadoop.workflow.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.mapper.StartNodeMapper;
import com.hzl.hadoop.workflow.entity.StartNodeEntity;
import com.hzl.hadoop.workflow.service.StartNodeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;



@Service("startNodeService")
public class StartNodeServiceImpl extends ServiceImpl<StartNodeMapper, StartNodeEntity> implements StartNodeService {

	@Autowired
    StartNodeMapper mapper;

    @Override
    public PageInfo queryPage(StartNodeEntity params,int start, int pageSize) {
		QueryWrapper<StartNodeEntity> queryWrapper = new QueryWrapper(params);

		PageInfo<StartNodeEntity> pageResult = PageHelper.startPage(start, pageSize).doSelectPageInfo(() -> mapper.selectList(queryWrapper));

        return pageResult;
    }

}