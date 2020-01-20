package com.hzl.hadoop.app.controller;

import com.hzl.hadoop.exception.CommonException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author hzl 2020/01/03 9:19 AM
 */
@RestController
public class ExceptionController {

	@RequestMapping("testException")
	public String testException() throws Exception {
		throw new CommonException("common.error");
	}

}
