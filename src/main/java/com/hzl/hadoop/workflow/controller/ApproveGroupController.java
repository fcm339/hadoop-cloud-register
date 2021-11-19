package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.ApproveGroupEntity;
import com.hzl.hadoop.workflow.service.ApproveGroupService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ApproveGroupVO;
import org.springframework.http.ResponseEntity;




/**
 * 审批组
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@RestController
@RequestMapping("workflow/approvegroup")
public class ApproveGroupController {
    @Autowired
    private ApproveGroupService approveGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<ApproveGroupEntity>> list(ApproveGroupEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ApproveGroupEntity> page = approveGroupService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<ApproveGroupEntity> info(@PathVariable("id") Long id){
		ApproveGroupEntity approveGroup = approveGroupService.getById(id);

        return new ResponseEntity(approveGroup,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody ApproveGroupEntity approveGroup){
		approveGroupService.save(approveGroup);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody ApproveGroupEntity approveGroup){
		approveGroupService.updateById(approveGroup);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		approveGroupService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
