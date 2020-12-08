package com.hzl.hadoop.order.controller;

import com.hzl.hadoop.app.dataobject.ContractDO;
import com.hzl.hadoop.app.service.MybatisService;
import com.hzl.hadoop.app.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 * 商品查询
 *
 * @author hzl 2020/01/03 10:24 PM
 */
@Slf4j
@RestController
@RequestMapping(value = "/order/api")
public class GoodsController {
	@Autowired
	MybatisService mybatisService;

	@Autowired
	RedisService redisService;


	/**
	 * <p>
	 * master数据库读取
	 * </p>
	 *
	 * @author hzl 2020/01/08 12:41 PM
	 */
	@GetMapping(value = "/search/like")
	public ResponseEntity<ContractDO> qeuery() {

		return new ResponseEntity<>(ContractDO.builder().name("测试").build(), HttpStatus.OK);
	}


}
