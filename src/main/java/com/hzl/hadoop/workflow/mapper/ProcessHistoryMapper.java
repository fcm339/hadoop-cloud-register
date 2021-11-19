package com.hzl.hadoop.workflow.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;;
import com.hzl.hadoop.workflow.entity.ProcessHistoryEntity;


/**
 * 流程记录
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@Mapper
public interface ProcessHistoryMapper extends BaseMapper<ProcessHistoryEntity> {
	
}
