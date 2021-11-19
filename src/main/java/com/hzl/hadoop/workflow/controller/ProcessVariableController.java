package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.ProcessVariableEntity;
import com.hzl.hadoop.workflow.service.ProcessVariableService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ProcessVariableVO;
import org.springframework.http.ResponseEntity;




/**
 * 流程变量
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:13
 */
@RestController
@RequestMapping("workflow/processvariable")
public class ProcessVariableController {
    @Autowired
    private ProcessVariableService processVariableService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<ProcessVariableEntity>> list(ProcessVariableEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ProcessVariableEntity> page = processVariableService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<ProcessVariableEntity> info(@PathVariable("id") Long id){
		ProcessVariableEntity processVariable = processVariableService.getById(id);

        return new ResponseEntity(processVariable,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody ProcessVariableEntity processVariable){
		processVariableService.save(processVariable);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody ProcessVariableEntity processVariable){
		processVariableService.updateById(processVariable);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		processVariableService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
