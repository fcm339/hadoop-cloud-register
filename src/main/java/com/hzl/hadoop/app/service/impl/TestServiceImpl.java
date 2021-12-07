package com.hzl.hadoop.app.service.impl;

import com.hzl.hadoop.app.mapper.Contractmapper;
import com.hzl.hadoop.app.service.TestService;
import com.hzl.hadoop.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * description
 *
 * @author hzl 2020/05/07 8:36 PM
 */
@Component
@Slf4j
public class TestServiceImpl implements TestService {

	@Autowired
	private Contractmapper contractmapper;

	@Override
	@Transactional
	public int update(int i) {
		log.info("日期");
		contractmapper.insertTest(i);
		if(i==0){
			throw new CommonException("故意抛出异常");
		}
		return 0;
	}


}
