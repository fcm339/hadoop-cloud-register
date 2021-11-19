package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.ApproveNodeEntity;
import com.hzl.hadoop.workflow.service.ApproveNodeService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ApproveNodeVO;
import org.springframework.http.ResponseEntity;




/**
 * 审批节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@RestController
@RequestMapping("workflow/approvenode")
public class ApproveNodeController {
    @Autowired
    private ApproveNodeService approveNodeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<ApproveNodeEntity>> list(ApproveNodeEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ApproveNodeEntity> page = approveNodeService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<ApproveNodeEntity> info(@PathVariable("id") Integer id){
		ApproveNodeEntity approveNode = approveNodeService.getById(id);

        return new ResponseEntity(approveNode,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody ApproveNodeEntity approveNode){
		approveNodeService.save(approveNode);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody ApproveNodeEntity approveNode){
		approveNodeService.updateById(approveNode);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Integer[] ids){
		approveNodeService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
