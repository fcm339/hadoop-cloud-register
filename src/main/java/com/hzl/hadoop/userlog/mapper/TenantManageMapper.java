package com.hzl.hadoop.userlog.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzl.hadoop.userlog.entity.TenantManageEntity;


/**
 * 租户管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-19 16:18:12
 */
@Mapper
public interface TenantManageMapper extends BaseMapper<TenantManageEntity> {
	
}
