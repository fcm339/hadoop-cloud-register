package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzl.hadoop.workflow.entity.ApproveHistoryApproverEntity;


/**
 * 审批节点审批历史
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-04 14:56:39
 */
@Mapper
public interface ApproveHistoryApproverMapper extends BaseMapper<ApproveHistoryApproverEntity> {
	
}
