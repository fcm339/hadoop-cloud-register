package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.ApproveHistoryEntity;
import com.hzl.hadoop.workflow.service.ApproveHistoryService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ApproveHistoryVO;
import org.springframework.http.ResponseEntity;




/**
 * 审批历史
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
@RestController
@RequestMapping("workflow/approvehistory")
public class ApproveHistoryController {
    @Autowired
    private ApproveHistoryService approveHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<ApproveHistoryEntity>> list(@RequestParam ApproveHistoryEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ApproveHistoryEntity> page = approveHistoryService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<ApproveHistoryEntity> info(@PathVariable("id") Long id){
		ApproveHistoryEntity approveHistory = approveHistoryService.getById(id);

        return new ResponseEntity(approveHistory,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody ApproveHistoryEntity approveHistory){
		approveHistoryService.save(approveHistory);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody ApproveHistoryEntity approveHistory){
		approveHistoryService.updateById(approveHistory);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		approveHistoryService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
