package com.hzl.hadoop.app.service.impl;

import com.hzl.hadoop.app.dataobject.ContractDO;
import com.hzl.hadoop.app.mapper.Contractmapper;
import com.hzl.hadoop.app.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * description
 *
 * @author hzl 2020/01/08 9:45 AM
 */
@Component
public class MybatisServiceimpl implements MybatisService {

	@Autowired
	Contractmapper contractmapper;

//	@Autowired
//	ContractSlavemapper contractSlavemapper;

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public ContractDO select() {
		return contractmapper.select();
	}

//	@Override
//	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
//	public ContractDO selectSlave() {
//		return contractSlavemapper.select();
//	}
}
