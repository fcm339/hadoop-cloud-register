package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.ProcessMountEntity;
import com.hzl.hadoop.workflow.service.ProcessMountService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ProcessMountVO;
import org.springframework.http.ResponseEntity;




/**
 * 流程挂载
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:13
 */
@RestController
@RequestMapping("workflow/processmount")
public class ProcessMountController {
    @Autowired
    private ProcessMountService processMountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<ProcessMountEntity>> list(ProcessMountEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ProcessMountEntity> page = processMountService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<ProcessMountEntity> info(@PathVariable("id") Long id){
		ProcessMountEntity processMount = processMountService.getById(id);

        return new ResponseEntity(processMount,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody ProcessMountEntity processMount){
		processMountService.save(processMount);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody ProcessMountEntity processMount){
		processMountService.updateById(processMount);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		processMountService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
