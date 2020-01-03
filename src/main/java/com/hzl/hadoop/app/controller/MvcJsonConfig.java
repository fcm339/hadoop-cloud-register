package com.hzl.hadoop.app.controller;

import com.hzl.hadoop.app.vo.PaymentVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 * WebMvcConfig中配置的消息转换器测试
 * @author hzl 2020/01/03 10:24 PM
 */
@RestController
public class MvcJsonConfig {

	@GetMapping(value = "/jsontest")
	public ResponseEntity<PaymentVO> jsonTest(){
		return new ResponseEntity<PaymentVO>(new PaymentVO(), HttpStatus.OK);
	}
}
