package com.hzl.hadoop.workflow.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.mapper.ApproveHistoryMapper;
import com.hzl.hadoop.workflow.entity.ApproveHistoryEntity;
import com.hzl.hadoop.workflow.service.ApproveHistoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;



@Service("approveHistoryService")
public class ApproveHistoryServiceImpl extends ServiceImpl<ApproveHistoryMapper, ApproveHistoryEntity> implements ApproveHistoryService {

	@Autowired
    ApproveHistoryMapper mapper;

    @Override
    public PageInfo queryPage(ApproveHistoryEntity params,int start, int pageSize) {
		QueryWrapper<ApproveHistoryEntity> queryWrapper = new QueryWrapper(params);

		PageInfo<ApproveHistoryEntity> pageResult = PageHelper.startPage(start, pageSize).doSelectPageInfo(() -> mapper.selectList(queryWrapper));

        return pageResult;
    }

}