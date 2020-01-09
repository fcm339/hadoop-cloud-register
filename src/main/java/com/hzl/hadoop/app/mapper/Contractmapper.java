package com.hzl.hadoop.app.mapper;

import com.hzl.hadoop.app.dataobject.ContractDO;
import com.hzl.hadoop.config.mybatis.BaseMapper;

/**
 * description
 *
 * @author hzl 2020/01/08 9:30 AM
 */
public interface Contractmapper extends BaseMapper<ContractDO> {

	ContractDO select();
}
