package com.hzl.hadoop.util;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author hzl 2021/09/14 11:29 AM
 */
@Component
public class SqlSessionUtils {

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public  SqlSession getSqlSessionBatch(){

		SqlSession sqlSession=sqlSessionFactory.openSession(ExecutorType.BATCH, true);
		return sqlSession;
	}
}
