package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.hzl.hadoop.config.mybatis.BaseMapperUtil;
import com.hzl.hadoop.workflow.entity.ApproveHistoryEntity;


/**
 * 审批历史
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
@Mapper
public interface ApproveHistoryMapper extends BaseMapperUtil<ApproveHistoryEntity> {
	
}
