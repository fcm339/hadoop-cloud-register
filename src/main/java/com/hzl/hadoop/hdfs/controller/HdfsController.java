package com.hzl.hadoop.hdfs.controller;

import com.alibaba.fastjson.JSONArray;
import com.hzl.hadoop.exception.CommonException;
import com.hzl.hadoop.hdfs.entity.FileDictory;
import com.hzl.hadoop.hdfs.service.HdfsTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.apache.commons.io.FileUtils.openInputStream;

/**
 * description
 * hdfs 分布式文件系统的上传文件，下载文件，删除文件
 *
 * @author hzl 2020/03/10 11:13 AM
 */
@Slf4j
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


	/** todo 上传有问题
	 * 文件上传
	 *
	 * @param path 路径/ss/3.txt
     * @param file 文件流
	 * @author hzl 2020-03-24 10:55 AM
	 * @return
	 */
	@PostMapping(value = "/upload")
	public boolean uploadFile(String path, MultipartFile file) {
		try {
			log.info("上传文件大小"+file.getSize());
			return hdfsTemplateService.uploadFile(path, file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	/** todo 下载有问题
	 * @param filePath /ss/3.txt   fileName 3.txt(下载文件)
	 * @param filePath /ss   fileName ss(下载文件夹)
	 * @return 参考https://blog.csdn.net/VincentlVL/article/details/99221928
	 * @author hzl 2020-03-20 3:33 PM
	 */
	@GetMapping(value = "/download")
	public void downFile(@RequestParam String filePath, @RequestParam String fileName, HttpServletResponse response) {
		try {
			try(InputStream inputStream = hdfsTemplateService.downloadFile(filePath)){
				response.setContentType("application/x-msdownload;charset=utf-8");
				response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
				try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream())){
					IOUtils.copy(inputStream, bufferedOutputStream);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("文件下载失败");
		}
	}

	public static String readFileToString(InputStream in) throws IOException {
		Throwable var3 = null;

		String var4;
		try {
			var4 = IOUtils.toString(in, Charsets.toCharset(StandardCharsets.UTF_8));
		} catch (Throwable var13) {
			var3 = var13;
			throw var13;
		} finally {
			if (in != null) {
				if (var3 != null) {
					try {
						in.close();
					} catch (Throwable var12) {
						var3.addSuppressed(var12);
					}
				} else {
					in.close();
				}
			}

		}

		return var4;
	}

}
