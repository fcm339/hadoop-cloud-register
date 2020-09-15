package com.hzl.hadoop.app.service.impl;

import com.hzl.hadoop.app.dataobject.ContractDO;
import com.hzl.hadoop.app.mapper.Contractmapper;
import com.hzl.hadoop.app.service.RedisService;
import com.hzl.hadoop.app.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
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
	@Autowired
	private TestService testService;

	//	@Autowired
//	private RedisUtils redisUtils;
	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public ContractDO selectRedis() {
		ContractDO contractDO = null;
		try {
			ValueOperations<String, ContractDO> operations = redisTemplate.opsForValue();
			contractDO = operations.get("contract_query:1");
			if (contractDO == null) {
				log.info("从数据库获取");
				contractDO = contractmapper.selectOne(ContractDO.builder().id(1L).build());
				List<ContractDO> contractDOList = new ArrayList<>();
				contractDOList.add(new ContractDO());
				//contractDO.setContractDOList(contractDOList);
				operations.set("contract_query:1", contractDO);
			} else {
				//date类型的数据存到redis后多了四个小时
				log.info("从redis中读取" + contractDO.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return contractDO;
	}

	@Override
	public int update(LocalDate localDate) {
		log.info("日期" + localDate);
		//contractmapper.updateByPrimaryKeySelective(ContractDO.builder().signatureDate(localDate).id(950L).build());
		contractmapper.updateDate(localDate);
		return 0;
	}

	@Override
	@Async("taskExecutor")
	public int update(Date localDate) {
		log.info("当前时间" + localDate);
		return 0;
	}

	@Override
	public Boolean threadTest(int i) {
		//log.info("开始启动多线程"+i);

		//testService.update(i);
		this.update(new Date());
		//log.info("开始启动多线程结束"+i);
		return false;
	}

	@Override
	public List<Long> selectRedisListLong() {
		List<Long> results = new ArrayList<>();
		results.add(1L);
		results.add(2L);
		String key = "redis:teset";
		Long s = 10005L;
		//设置键的序列号为string
		redisTemplate.delete(key);
		redisTemplate.opsForList().rightPushAll(key.concat(s.toString()), results.toArray());
		System.out.println("测试" + results.toArray());
		System.out.println(redisTemplate.opsForList().range(key.concat(s.toString()), 0, -1));

		return redisTemplate.opsForList().range(key.concat(s.toString()), 0, -1);
	}

	public static void main(String args[]) {
		Long s = 10005L;
		String k = "CSll";
		System.out.println(k.concat(String.valueOf(s)));
	}

}
