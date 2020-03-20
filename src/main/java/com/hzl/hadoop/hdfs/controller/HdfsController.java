package com.hzl.hadoop.hdfs.controller;

import com.hzl.hadoop.exception.CommonException;
import com.hzl.hadoop.hdfs.entity.FileDictory;
import com.hzl.hadoop.hdfs.service.HdfsTemplateService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * description
 * hdfs 分布式文件系统的上传文件，下载文件，删除文件
 *
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
	public boolean createDir(@RequestParam String path) {
		try {
			return hdfsTemplateService.mkdir(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}


	@GetMapping(value = "/delete/dir")
	public boolean deleteDir(@RequestParam String path, @RequestParam boolean force) {
		try {
			return hdfsTemplateService.dlDir(path, force);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}


	@GetMapping(value = "/query/exist")
	public boolean queryDir(@RequestParam String path) {
		try {
			return hdfsTemplateService.hasDirOrFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 建议一个目录一个目录的查询，一下子加载所有的文件比较卡，需要用到递归查询
	 *
	 * @param path
	 * @return
	 * @author hzl 2020-03-19 6:00 PM
	 */
	@GetMapping(value = "/query/detail")
	public ResponseEntity<List<FileDictory>> queryDetail(@RequestParam String path) {
		try {
			return new ResponseEntity<>(hdfsTemplateService.queryTree(path), HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@PostMapping(value = "/upload")
	public boolean uploadFile(String path, MultipartFile file) {
		try {
			return hdfsTemplateService.uploadFile(path, file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * @param filePath /ss/3.txt   fileName 3.txt(下载文件)
	 * @param filePath /ss   fileName ss(下载文件夹)
	 * @return 参考https://blog.csdn.net/VincentlVL/article/details/99221928
	 * @author hzl 2020-03-20 3:33 PM
	 */
	@GetMapping(value = "/download",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<InputStreamResource> downFile(@RequestParam String filePath, @RequestParam String fileName) {
		try {
			InputStream inputStream = hdfsTemplateService.downloadFile(filePath);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
			headers.add("Content-Disposition", String.format("attachment;filename=\"%s\"", URLEncoder.encode(fileName, StandardCharsets.UTF_8.name())));
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");
			return ResponseEntity.ok().headers(headers)
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(new InputStreamResource(inputStream));
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("文件下载失败");
		}

	}


}
