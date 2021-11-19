package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;;
import com.hzl.hadoop.workflow.entity.ApproveGroupUserEntity;


/**
 * 审批组人员
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@Mapper
public interface ApproveGroupUserMapper extends BaseMapper<ApproveGroupUserEntity> {
	
}
