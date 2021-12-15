package com.hzl.hadoop.gp.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzl.hadoop.gp.entity.GpNewsEntity;


/**
 * 个股新闻
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-12-15 11:08:17
 */
@Mapper
public interface GpNewsMapper extends BaseMapper<GpNewsEntity> {
	
}
