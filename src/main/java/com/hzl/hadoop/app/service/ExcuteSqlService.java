package com.hzl.hadoop.app.service;

import com.hzl.hadoop.app.dataobject.ExcuteSqlDO;
import com.hzl.hadoop.app.dataobject.ExcuteSqlOauthDO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * description
 *
 * @author hzl 2020/11/16 3:06 PM
 */
public interface ExcuteSqlService {
	//查看当前用户的sql
	List<ExcuteSqlDO> selectSql(ExcuteSqlDO excuteSqlDO);

	//授权
	int addOauth(ExcuteSqlOauthDO excuteSqlOauthDO);

	//查看授权
	List<ExcuteSqlOauthDO> selectOauth(ExcuteSqlOauthDO excuteSqlOauthDO);

	//执行sql查询，并导出excel
	void excuteSql(HttpServletResponse response, ExcuteSqlDO excuteSqlDO);
}
