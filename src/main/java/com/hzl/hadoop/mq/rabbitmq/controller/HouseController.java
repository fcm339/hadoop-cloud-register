package com.hzl.hadoop.mq.rabbitmq.controller;

import com.hzl.hadoop.mq.rabbitmq.producer.HouseProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 * 参考https://gitee.com/luodea_admin/Springboot-Rabbitmq/tree/master/rabbitmq-publish#topic%E4%BA%A4%E6%8D%A2%E5%99%A8%E5%AE%9E%E6%88%98
 * https://gitee.com/zhangbw666/springboot-rabbitmq#%E5%85%ABspring-%E7%9A%84%E4%BA%8B%E4%BB%B6%E9%A9%B1%E5%8A%A8%E6%A8%A1%E5%9E%8B
 * cnblogs.com/qts-hope/p/11242559.html
 * @author hzl 2021/11/09 2:44 PM
 */
@Slf4j
@RestController
@RequestMapping("mq")
public class HouseController {

	@Autowired
	HouseProducer houseProducer;

	@GetMapping(value = "/send/house")
	public ResponseEntity sendHouse() {
		houseProducer.publish();
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
