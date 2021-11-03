package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.hzl.hadoop.config.mybatis.BaseMapperUtil;
import com.hzl.hadoop.workflow.entity.ApproverEntity;


/**
 * 审批人
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
@Mapper
public interface ApproverMapper extends BaseMapperUtil<ApproverEntity> {
	
}
