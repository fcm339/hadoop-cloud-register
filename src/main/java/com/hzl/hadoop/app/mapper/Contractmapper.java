package com.hzl.hadoop.app.mapper;

import com.hzl.hadoop.app.dataobject.ContractDO;
import com.hzl.hadoop.config.mybatis.BaseMapperUtil;
import org.apache.ibatis.annotations.Mapper;

/**
 * description
 *
 * @author hzl 2020/01/08 9:30 AM
 */
@Mapper
public interface Contractmapper extends BaseMapperUtil<ContractDO> {

	ContractDO selectTest();
}
