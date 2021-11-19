package com.hzl.hadoop.interfacemanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.interfacemanager.entity.InterfaceManageEntity;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.interfacemanager.vo.InterfaceManageVO;


import java.util.Map;
import java.util.Set;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-16 14:05:48
 */
public interface InterfaceManageService extends IService<InterfaceManageEntity> {

	PageInfo queryPage(InterfaceManageEntity params, int start, int pageSize);

	Set<String> selectUrls(InterfaceManageVO interfaceManageVO);
}

