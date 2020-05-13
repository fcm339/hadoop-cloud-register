package com.hzl.hadoop.app.service;

import com.hzl.hadoop.app.dataobject.ContractDO;

import java.time.LocalDate;
import java.util.Date;

/**
 * description
 *
 * @author hzl 2020/01/19 1:00 PM
 */
public interface RedisService {

	ContractDO selectRedis();

	int update(LocalDate localDate);

	int update(Date localDate);

	Boolean threadTest(int i);


}
