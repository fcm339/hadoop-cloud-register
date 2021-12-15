package com.hzl.hadoop.gp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.gp.entity.GpNewsEntity;
import com.hzl.hadoop.gp.mapper.GpNewsMapper;
import com.hzl.hadoop.gp.service.GpNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("gpNewsService")
public class GpNewsServiceImpl extends ServiceImpl<GpNewsMapper, GpNewsEntity> implements GpNewsService {

	@Autowired
	GpNewsMapper mapper;

	@Override
	public PageInfo queryPage(GpNewsEntity params, int start, int pageSize) {
		QueryWrapper<GpNewsEntity> queryWrapper = new QueryWrapper(params);

		PageInfo<GpNewsEntity> pageResult = PageHelper.startPage(start, pageSize).doSelectPageInfo(() -> mapper.selectList(queryWrapper));

		return pageResult;
	}

}