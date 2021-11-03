package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.ProcessHistoryEntity;
import com.hzl.hadoop.workflow.service.ProcessHistoryService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ProcessHistoryVO;
import org.springframework.http.ResponseEntity;




/**
 * 流程记录
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
@RestController
@RequestMapping("workflow/processhistory")
public class ProcessHistoryController {
    @Autowired
    private ProcessHistoryService processHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<ProcessHistoryEntity>> list(@RequestParam ProcessHistoryEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ProcessHistoryEntity> page = processHistoryService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<ProcessHistoryEntity> info(@PathVariable("id") Long id){
		ProcessHistoryEntity processHistory = processHistoryService.getById(id);

        return new ResponseEntity(processHistory,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody ProcessHistoryEntity processHistory){
		processHistoryService.save(processHistory);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody ProcessHistoryEntity processHistory){
		processHistoryService.updateById(processHistory);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		processHistoryService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
