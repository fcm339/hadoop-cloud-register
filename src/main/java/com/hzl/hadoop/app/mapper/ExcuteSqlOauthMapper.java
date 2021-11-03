package com.hzl.hadoop.app.mapper;

import com.hzl.hadoop.app.dataobject.ExcuteSqlOauthDO;
import com.hzl.hadoop.config.mybatis.BaseMapperUtil;
import org.apache.ibatis.annotations.Mapper;

/**
 * description
 *
 * @author hzl 2020/11/16 2:53 PM
 */
@Mapper
public interface ExcuteSqlOauthMapper extends BaseMapperUtil<ExcuteSqlOauthDO> {

	//授权
	int addOauth(ExcuteSqlOauthDO excuteSqlOauthDO);
}
