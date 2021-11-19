package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hzl.hadoop.workflow.entity.ApproveHistoryApproverEntity;
import com.hzl.hadoop.workflow.service.ApproveHistoryApproverService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ApproveHistoryApproverVO;
import org.springframework.http.ResponseEntity;




/**
 * 审批节点审批历史
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-04 14:56:39
 */
@RestController
@RequestMapping("workflow/approvehistoryapprover")
public class ApproveHistoryApproverController {
    @Autowired
    private ApproveHistoryApproverService approveHistoryApproverService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public ResponseEntity<PageInfo<ApproveHistoryApproverEntity>> list(ApproveHistoryApproverEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ApproveHistoryApproverEntity> page = approveHistoryApproverService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<ApproveHistoryApproverEntity> info(@PathVariable("id") Long id){
		ApproveHistoryApproverEntity approveHistoryApprover = approveHistoryApproverService.getById(id);

        return new ResponseEntity(approveHistoryApprover,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ApproveHistoryApproverEntity approveHistoryApprover){
		approveHistoryApproverService.save(approveHistoryApprover);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody ApproveHistoryApproverEntity approveHistoryApprover){
		approveHistoryApproverService.updateById(approveHistoryApprover);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		approveHistoryApproverService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
