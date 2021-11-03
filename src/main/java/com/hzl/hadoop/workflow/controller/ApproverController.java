package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.ApproverEntity;
import com.hzl.hadoop.workflow.service.ApproverService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ApproverVO;
import org.springframework.http.ResponseEntity;




/**
 * 审批人
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
@RestController
@RequestMapping("workflow/approver")
public class ApproverController {
    @Autowired
    private ApproverService approverService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<ApproverEntity>> list(@RequestParam ApproverEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ApproverEntity> page = approverService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<ApproverEntity> info(@PathVariable("id") Long id){
		ApproverEntity approver = approverService.getById(id);

        return new ResponseEntity(approver,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody ApproverEntity approver){
		approverService.save(approver);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody ApproverEntity approver){
		approverService.updateById(approver);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		approverService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
