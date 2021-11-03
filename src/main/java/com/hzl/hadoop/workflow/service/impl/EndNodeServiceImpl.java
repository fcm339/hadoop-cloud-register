package com.hzl.hadoop.workflow.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.mapper.EndNodeMapper;
import com.hzl.hadoop.workflow.entity.EndNodeEntity;
import com.hzl.hadoop.workflow.service.EndNodeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;



@Service("endNodeService")
public class EndNodeServiceImpl extends ServiceImpl<EndNodeMapper, EndNodeEntity> implements EndNodeService {

	@Autowired
    EndNodeMapper mapper;

    @Override
    public PageInfo queryPage(EndNodeEntity params,int start, int pageSize) {
		QueryWrapper<EndNodeEntity> queryWrapper = new QueryWrapper(params);

		PageInfo<EndNodeEntity> pageResult = PageHelper.startPage(start, pageSize).doSelectPageInfo(() -> mapper.selectList(queryWrapper));

        return pageResult;
    }

}