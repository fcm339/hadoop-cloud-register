package com.hzl.hadoop.gp.controller;

import com.hzl.hadoop.gp.service.GpService;
import com.hzl.hadoop.gp.vo.GpVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 * 伊利股票
 *
 * @author hzl 2020/10/31 5:20 PM
 */
@Slf4j
@RestController
public class GpController {

	private GpService gpService;

	public GpController(GpService gpService) {
		this.gpService = gpService;

	}

	/**
	 * <p>
	 * 获取伊利股票信息，插入数据库
	 * </p>
	 *
	 * @author hzl 2020/01/08 12:41 PM
	 */
	@GetMapping(value = "/gp/yl/insert/{code}")
	public ResponseEntity<GpVO> insert(@PathVariable String code) {
		return new ResponseEntity<>(gpService.insert(code), HttpStatus.OK);
	}




}
