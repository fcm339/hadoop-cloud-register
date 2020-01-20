package com.hzl.hadoop.app.service.impl;

import com.hzl.hadoop.app.dataobject.ContractDO;
import com.hzl.hadoop.app.service.MybatisService;
import com.hzl.hadoop.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.hzl.hadoop.app.mapper.Contractmapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * description
 *
 * @author hzl 2020/01/08 9:45 AM
 */
@Component
@Slf4j
public class MybatisServiceimpl implements MybatisService,DisposableBean {

	@Autowired
	private Contractmapper contractmapper;

	//	@Autowired
//	ContractSlavemapper contractSlavemapper;

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public ContractDO select() {

		//int i=contractmapper.update();
//		if(i==1){
//			throw new CommonException("回滚测试");
//		}
		log.info("查询结果"+contractmapper.selectOne(ContractDO.builder().id(950L).build()));
		return contractmapper.selectOne(ContractDO.builder().id(950L).build());
	}

	@Override
	public void destroy() throws Exception {
		log.info("MybatisServiceimpl执行销毁方法");
	}

//	@Override
//	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
//	public ContractDO selectSlave() {
//		return contractSlavemapper.select();
//	}
}
