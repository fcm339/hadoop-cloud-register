package com.hzl.hadoop.app.mapper;

import com.hzl.hadoop.app.dataobject.ContractDO;
import com.hzl.hadoop.config.mybatis.DataSource;
import org.apache.ibatis.annotations.Mapper;

/**
 * description
 *
 * @author hzl 2020/01/08 9:30 AM
 */
public interface Contractmapper {

	ContractDO select();
}
