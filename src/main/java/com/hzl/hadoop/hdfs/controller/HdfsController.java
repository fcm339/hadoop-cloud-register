package com.hzl.hadoop.hdfs.controller;

import com.hzl.hadoop.hdfs.service.HdfsTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * description
 * hdfs 分布式文件系统的上传文件，下载文件，删除文件
 * @author hzl 2020/03/10 11:13 AM
 */
@RestController
@RequestMapping(value = "/hdfs")
public class HdfsController {

	HdfsTemplateService hdfsTemplateService;

	public HdfsController(HdfsTemplateService hdfsTemplateService) {
		this.hdfsTemplateService = hdfsTemplateService;
	}

	@GetMapping(value = "/create/dir")
	public boolean createDir(@RequestParam String path){
		try {
			return hdfsTemplateService.mkdir(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}


	@GetMapping(value = "/delete/dir")
	public boolean deleteDir(@RequestParam String path,@RequestParam boolean force){
		try {
			return hdfsTemplateService.dlDir(path,force);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}


	@GetMapping(value = "/query/exist")
	public boolean queryDir(@RequestParam String path){
		try {
			return hdfsTemplateService.hasDirOrFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
