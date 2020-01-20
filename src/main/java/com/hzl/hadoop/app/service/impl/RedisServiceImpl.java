package com.hzl.hadoop.app.service.impl;

import com.hzl.hadoop.app.dataobject.ContractDO;
import com.hzl.hadoop.app.mapper.Contractmapper;
import com.hzl.hadoop.app.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description redis操作类例子
 *
 * @author hzl 2020/01/19 1:01 PM
 */
@Component
@Slf4j
public class RedisServiceImpl implements RedisService {


	@Autowired
	private Contractmapper contractmapper;

	//	@Autowired
//	private RedisUtils redisUtils;
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public ContractDO selectRedis() {
		ContractDO contractDO=null;
		try{
			ValueOperations<String, ContractDO> operations = redisTemplate.opsForValue();
			 contractDO = operations.get("contract_query:950");
			if (contractDO == null) {
				log.info("从数据库获取");
				contractDO = contractmapper.selectOne(ContractDO.builder().id(950L).build());
				List<ContractDO> contractDOList =new ArrayList<>();
				contractDOList.add(new ContractDO());
				//contractDO.setContractDOList(contractDOList);
				operations.set("contract_query:950", contractDO);
			} else {
				log.info("从redis中读取"+contractDO.toString());
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		return contractDO;
	}

	@Override
	public int update(LocalDate localDate) {
		// TODO: 2020/1/20 日期存到数据库时间变了 2019-09-01变成了2019-08-30 
		log.info("日期"+localDate);
		//contractmapper.updateByPrimaryKeySelective(ContractDO.builder().signatureDate(localDate).id(950L).build());
		contractmapper.updateDate(localDate);
		return 0;
	}

	@Override
	public int update(Date localDate) {
		contractmapper.updateDate1(new Date("2019-09-01"));
		return 0;
	}
}
