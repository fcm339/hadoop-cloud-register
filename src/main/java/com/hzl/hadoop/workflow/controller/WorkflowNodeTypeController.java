package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.WorkflowNodeTypeEntity;
import com.hzl.hadoop.workflow.service.WorkflowNodeTypeService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.WorkflowNodeTypeVO;
import org.springframework.http.ResponseEntity;




/**
 * 审批节点类型
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
@RestController
@RequestMapping("workflow/workflownodetype")
public class WorkflowNodeTypeController {
    @Autowired
    private WorkflowNodeTypeService workflowNodeTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<WorkflowNodeTypeEntity>> list(@RequestParam WorkflowNodeTypeEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<WorkflowNodeTypeEntity> page = workflowNodeTypeService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<WorkflowNodeTypeEntity> info(@PathVariable("id") Long id){
		WorkflowNodeTypeEntity workflowNodeType = workflowNodeTypeService.getById(id);

        return new ResponseEntity(workflowNodeType,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody WorkflowNodeTypeEntity workflowNodeType){
		workflowNodeTypeService.save(workflowNodeType);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody WorkflowNodeTypeEntity workflowNodeType){
		workflowNodeTypeService.updateById(workflowNodeType);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		workflowNodeTypeService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
