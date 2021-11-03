package com.hzl.hadoop.workflow.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.mapper.ApproveNodeMapper;
import com.hzl.hadoop.workflow.entity.ApproveNodeEntity;
import com.hzl.hadoop.workflow.service.ApproveNodeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;



@Service("approveNodeService")
public class ApproveNodeServiceImpl extends ServiceImpl<ApproveNodeMapper, ApproveNodeEntity> implements ApproveNodeService {

	@Autowired
    ApproveNodeMapper mapper;

    @Override
    public PageInfo queryPage(ApproveNodeEntity params,int start, int pageSize) {
		QueryWrapper<ApproveNodeEntity> queryWrapper = new QueryWrapper(params);

		PageInfo<ApproveNodeEntity> pageResult = PageHelper.startPage(start, pageSize).doSelectPageInfo(() -> mapper.selectList(queryWrapper));

        return pageResult;
    }

}