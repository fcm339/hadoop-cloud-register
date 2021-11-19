package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hzl.hadoop.workflow.entity.ApproveHistoryEndEntity;
import com.hzl.hadoop.workflow.service.ApproveHistoryEndService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.ApproveHistoryEndVO;
import org.springframework.http.ResponseEntity;




/**
 * 结束节点审批历史
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-04 14:56:39
 */
@RestController
@RequestMapping("workflow/approvehistoryend")
public class ApproveHistoryEndController {
    @Autowired
    private ApproveHistoryEndService approveHistoryEndService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public ResponseEntity<PageInfo<ApproveHistoryEndEntity>> list(ApproveHistoryEndEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<ApproveHistoryEndEntity> page = approveHistoryEndService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public ResponseEntity<ApproveHistoryEndEntity> info(@PathVariable("id") Long id){
		ApproveHistoryEndEntity approveHistoryEnd = approveHistoryEndService.getById(id);

        return new ResponseEntity(approveHistoryEnd,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ApproveHistoryEndEntity approveHistoryEnd){
		approveHistoryEndService.save(approveHistoryEnd);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody ApproveHistoryEndEntity approveHistoryEnd){
		approveHistoryEndService.updateById(approveHistoryEnd);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		approveHistoryEndService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
