package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;;
import com.hzl.hadoop.workflow.entity.ApproveNodeEntity;


/**
 * 审批节点
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@Mapper
public interface ApproveNodeMapper extends BaseMapper<ApproveNodeEntity> {
	
}
