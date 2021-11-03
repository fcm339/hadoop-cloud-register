package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.EndNodeEntity;
import com.hzl.hadoop.workflow.service.EndNodeService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.EndNodeVO;
import org.springframework.http.ResponseEntity;




/**
 * 结束节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
@RestController
@RequestMapping("workflow/endnode")
public class EndNodeController {
    @Autowired
    private EndNodeService endNodeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<EndNodeEntity>> list(@RequestParam EndNodeEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<EndNodeEntity> page = endNodeService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<EndNodeEntity> info(@PathVariable("id") Long id){
		EndNodeEntity endNode = endNodeService.getById(id);

        return new ResponseEntity(endNode,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody EndNodeEntity endNode){
		endNodeService.save(endNode);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody EndNodeEntity endNode){
		endNodeService.updateById(endNode);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		endNodeService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
