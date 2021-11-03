package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.ApproveGroupUserEntity;
import com.hzl.hadoop.workflow.service.ApproveGroupUserService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ApproveGroupUserVO;
import org.springframework.http.ResponseEntity;




/**
 * 审批组人员
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
@RestController
@RequestMapping("workflow/approvegroupuser")
public class ApproveGroupUserController {
    @Autowired
    private ApproveGroupUserService approveGroupUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<ApproveGroupUserEntity>> list(@RequestParam ApproveGroupUserEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ApproveGroupUserEntity> page = approveGroupUserService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<ApproveGroupUserEntity> info(@PathVariable("id") Long id){
		ApproveGroupUserEntity approveGroupUser = approveGroupUserService.getById(id);

        return new ResponseEntity(approveGroupUser,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody ApproveGroupUserEntity approveGroupUser){
		approveGroupUserService.save(approveGroupUser);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody ApproveGroupUserEntity approveGroupUser){
		approveGroupUserService.updateById(approveGroupUser);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		approveGroupUserService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
