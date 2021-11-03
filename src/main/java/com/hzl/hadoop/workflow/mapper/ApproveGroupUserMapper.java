package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.hzl.hadoop.config.mybatis.BaseMapperUtil;
import com.hzl.hadoop.workflow.entity.ApproveGroupUserEntity;


/**
 * 审批组人员
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
@Mapper
public interface ApproveGroupUserMapper extends BaseMapperUtil<ApproveGroupUserEntity> {
	
}
