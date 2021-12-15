package com.hzl.hadoop.gp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzl.hadoop.gp.entity.GpNewsEntity;
import com.github.pagehelper.PageInfo;


import java.util.Map;

/**
 * 个股新闻
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-12-15 11:08:17
 */
public interface GpNewsService extends IService<GpNewsEntity> {

	PageInfo queryPage(GpNewsEntity params, int start, int pageSize);
}

