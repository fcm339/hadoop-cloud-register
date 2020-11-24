package com.hzl.hadoop.app.service.impl;

import com.hzl.hadoop.app.dataobject.ExcuteSqlDO;
import com.hzl.hadoop.app.dataobject.ExcuteSqlOauthDO;
import com.hzl.hadoop.app.mapper.ExcuteSqlMapper;
import com.hzl.hadoop.app.mapper.ExcuteSqlOauthMapper;
import com.hzl.hadoop.app.service.ExcuteSqlService;
import com.hzl.hadoop.util.EasyExcelUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * description
 *
 * @author hzl 2020/11/16 3:06 PM
 */
@Service
public class ExcuteSqlServiceimpl implements ExcuteSqlService {
	private ExcuteSqlMapper excuteSqlMapper;

	private ExcuteSqlOauthMapper excuteSqlOauthMapper;

	public ExcuteSqlServiceimpl(ExcuteSqlMapper excuteSqlMapper, ExcuteSqlOauthMapper excuteSqlOauthMapper) {
		this.excuteSqlMapper = excuteSqlMapper;
		this.excuteSqlOauthMapper = excuteSqlOauthMapper;
	}

	@Override
	public List<ExcuteSqlDO> selectSql(ExcuteSqlDO excuteSqlDO) {
		return excuteSqlMapper.selectSql(excuteSqlDO);
	}

	@Override
	public int addOauth(ExcuteSqlOauthDO excuteSqlOauthDO) {
		return excuteSqlOauthMapper.insert(excuteSqlOauthDO);
	}

	@Override
	public List<ExcuteSqlOauthDO> selectOauth(ExcuteSqlOauthDO excuteSqlOauthDO) {
		return excuteSqlOauthMapper.select(excuteSqlOauthDO);
	}

	@Override
	public void excuteSql(HttpServletResponse response,ExcuteSqlDO excuteSqlDO) {
		List<LinkedHashMap<String, Object>> result=excuteSqlMapper.executeSql(excuteSqlDO.getSqlString());
		try {
			EasyExcelUtils.downloadFailedUsingJson(response,result,"模版");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
