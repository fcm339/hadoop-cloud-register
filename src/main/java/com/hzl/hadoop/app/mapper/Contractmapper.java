package com.hzl.hadoop.app.mapper;

import com.hzl.hadoop.config.mybatis.BaseMapperUtil;
import com.hzl.hadoop.app.dataobject.ContractDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;

/**
 * description
 *
 * @author hzl 2020/01/08 9:30 AM
 */
@Mapper
public interface Contractmapper extends BaseMapperUtil<ContractDO> {

	ContractDO selectTest();

	int update();

	int updateDate(@Param("localDate") LocalDate localDate);

	int updateDate1(@Param("localDate") Date localDate);

	int insertTest(@Param("i") int i);

}
