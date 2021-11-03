package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.StartNodeEntity;
import com.hzl.hadoop.workflow.service.StartNodeService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.StartNodeVO;
import org.springframework.http.ResponseEntity;




/**
 * 开始节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
@RestController
@RequestMapping("workflow/startnode")
public class StartNodeController {
    @Autowired
    private StartNodeService startNodeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<StartNodeEntity>> list(@RequestParam StartNodeEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<StartNodeEntity> page = startNodeService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<StartNodeEntity> info(@PathVariable("id") Integer id){
		StartNodeEntity startNode = startNodeService.getById(id);

        return new ResponseEntity(startNode,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody StartNodeEntity startNode){
		startNodeService.save(startNode);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody StartNodeEntity startNode){
		startNodeService.updateById(startNode);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Integer[] ids){
		startNodeService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
