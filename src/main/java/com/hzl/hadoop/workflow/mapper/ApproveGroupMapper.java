package com.hzl.hadoop.workflow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.hzl.hadoop.workflow.entity.ApproveGroupEntity;


/**
 * 审批组
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@Mapper
public interface ApproveGroupMapper extends BaseMapper<ApproveGroupEntity> {
	
}
