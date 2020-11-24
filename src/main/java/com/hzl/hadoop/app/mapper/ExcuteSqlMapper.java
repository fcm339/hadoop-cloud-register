package com.hzl.hadoop.app.mapper;

import com.hzl.hadoop.app.dataobject.ExcuteSqlDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * description
 *
 * @author hzl 2020/11/16 2:36 PM
 */
@Mapper
public interface ExcuteSqlMapper {

	List<LinkedHashMap<String, Object>> executeSql(String sql);

	List<ExcuteSqlDO> selectSql(ExcuteSqlDO excuteSqlDO);

}
