package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzl.hadoop.workflow.entity.WorkflowCharEntity;


/**
 * 前端生成的流程图，需要转换成开始节点，审批节点，网关节点，结束节点
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-24 09:34:57
 */
@Mapper
public interface WorkflowCharMapper extends BaseMapper<WorkflowCharEntity> {
	
}
