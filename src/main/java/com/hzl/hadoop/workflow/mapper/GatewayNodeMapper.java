package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.hzl.hadoop.config.mybatis.BaseMapperUtil;
import com.hzl.hadoop.workflow.entity.GatewayNodeEntity;


/**
 * 网关节点
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
@Mapper
public interface GatewayNodeMapper extends BaseMapperUtil<GatewayNodeEntity> {
	
}
