package com.hzl.hadoop.workflow.controller;

import com.hzl.hadoop.workflow.engine.StartWorkFlowEngine;
import com.hzl.hadoop.workflow.vo.StartWorkFlowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 * 流程启动接口
 *
 * @author hzl 2021/11/04 1:04 PM
 */
@RestController
@RequestMapping("workflow/start")
public class StartWorkFlowController {

	@Autowired
	StartWorkFlowEngine startWorkFlowEngine;

	/**
	 * 启动工作流
	 */
	@PostMapping("/workflow")
	public ResponseEntity startWorkFlow(@RequestBody StartWorkFlowVO startWorkFlowVO) {
		startWorkFlowEngine.startWorkFlow(startWorkFlowVO);
		return new ResponseEntity(HttpStatus.OK);
	}
}
