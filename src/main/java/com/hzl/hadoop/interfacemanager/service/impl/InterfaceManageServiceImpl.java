package com.hzl.hadoop.interfacemanager.service.impl;

import com.hzl.hadoop.interfacemanager.vo.InterfaceManageVO;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.interfacemanager.mapper.InterfaceManageMapper;
import com.hzl.hadoop.interfacemanager.entity.InterfaceManageEntity;
import com.hzl.hadoop.interfacemanager.service.InterfaceManageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Set;


@Service("interfaceManageService")
public class InterfaceManageServiceImpl extends ServiceImpl<InterfaceManageMapper, InterfaceManageEntity> implements InterfaceManageService {

	@Autowired
    InterfaceManageMapper mapper;

    @Override
    public PageInfo queryPage(InterfaceManageEntity params,int start, int pageSize) {
		QueryWrapper<InterfaceManageEntity> queryWrapper = new QueryWrapper(params);

		PageInfo<InterfaceManageEntity> pageResult = PageHelper.startPage(start, pageSize).doSelectPageInfo(() -> mapper.selectList(queryWrapper));

        return pageResult;
    }

	@Override
	public Set<String> selectUrls(InterfaceManageVO interfaceManageVO) {

		return mapper.selectUrls(interfaceManageVO);
	}

}