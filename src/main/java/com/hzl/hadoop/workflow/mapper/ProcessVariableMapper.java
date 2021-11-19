package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;;
import com.hzl.hadoop.workflow.entity.ProcessVariableEntity;


/**
 * 流程变量
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:13
 */
@Mapper
public interface ProcessVariableMapper extends BaseMapper<ProcessVariableEntity> {
	
}
