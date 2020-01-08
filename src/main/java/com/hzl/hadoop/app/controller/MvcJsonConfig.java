package com.hzl.hadoop.app.controller;

import com.hzl.hadoop.app.dataobject.ContractDO;
import com.hzl.hadoop.app.service.MybatisService;
import com.hzl.hadoop.app.vo.PaymentVO;
import com.hzl.hadoop.config.mybatis.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 * WebMvcConfig中配置的消息转换器测试
 *
 * @author hzl 2020/01/03 10:24 PM
 */
@RestController
public class MvcJsonConfig {
    @Autowired
	MybatisService mybatisService;

	@GetMapping(value = "/jsontest")
	public ResponseEntity<PaymentVO> jsonTest() {
		return new ResponseEntity<PaymentVO>(new PaymentVO(), HttpStatus.OK);
	}
	
	/**
	 * <p>
	 * master数据库读取
	 * </p>
	 * 
	 * @author hzl 2020/01/08 12:41 PM
	 */
	@GetMapping(value = "/query")
	public ResponseEntity<ContractDO> qeuery() {

		return new ResponseEntity<ContractDO>(mybatisService.select(), HttpStatus.OK);
	}
	/**
	 * <p>
	 * slave1数据库读取
	 * </p>
	 * 
	 * @author hzl 2020/01/08 12:42 PM
	 */
	@GetMapping(value = "/querysalve")
	@DataSource(name = "salve1")
	public ResponseEntity<ContractDO> qeuerySlave() {

		return new ResponseEntity<ContractDO>(mybatisService.select(), HttpStatus.OK);
	}
}
