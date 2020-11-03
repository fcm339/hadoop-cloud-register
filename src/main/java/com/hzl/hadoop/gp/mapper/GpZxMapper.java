package com.hzl.hadoop.gp.mapper;

import com.hzl.cloud.config.mybatis.BaseMapperUtil;
import com.hzl.hadoop.gp.vo.ZXVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * description
 *
 * @author hzl 2020/11/03 12:32 PM
 */
@Mapper
public interface GpZxMapper extends BaseMapperUtil<ZXVO> {
}
