package com.hzl.hadoop.workflow.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzl.hadoop.workflow.entity.GatewayNodeEntity;
import com.hzl.hadoop.workflow.service.GatewayNodeService;
import com.github.pagehelper.PageInfo;
import com.hzl.hadoop.workflow.vo.GatewayNodeVO;
import org.springframework.http.ResponseEntity;




/**
 * 网关节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:25
 */
@RestController
@RequestMapping("workflow/gatewaynode")
public class GatewayNodeController {
    @Autowired
    private GatewayNodeService gatewayNodeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseEntity<PageInfo<GatewayNodeEntity>> list(@RequestParam GatewayNodeEntity params,@RequestParam int start, @RequestParam int pageSize){
		PageInfo<GatewayNodeEntity> page = gatewayNodeService.queryPage(params,start,pageSize);

        return new ResponseEntity(page, HttpStatus.OK);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseEntity<GatewayNodeEntity> info(@PathVariable("id") Long id){
		GatewayNodeEntity gatewayNode = gatewayNodeService.getById(id);

        return new ResponseEntity(gatewayNode,HttpStatus.OK);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseEntity save(@RequestBody GatewayNodeEntity gatewayNode){
		gatewayNodeService.save(gatewayNode);

		return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseEntity update(@RequestBody GatewayNodeEntity gatewayNode){
		gatewayNodeService.updateById(gatewayNode);

        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseEntity delete(@RequestBody Long[] ids){
		gatewayNodeService.removeByIds(Arrays.asList(ids));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
