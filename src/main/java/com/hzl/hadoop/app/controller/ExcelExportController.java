package com.hzl.hadoop.app.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hzl.hadoop.app.dataobject.ExcuteSqlDO;
import com.hzl.hadoop.app.service.ExcuteSqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * description
 *
 * @author hzl 2020/11/16 3:38 PM
 */
@RestController
@Slf4j
@DS("slave1")
public class ExcelExportController {

	private ExcuteSqlService excuteSqlService;

	public ExcelExportController(ExcuteSqlService excuteSqlService) {
		this.excuteSqlService = excuteSqlService;
	}

	/**
	 * <p>
	 * 通用文件下载，可以下载任何格式的文件
	 * </p>
	 *
	 * @author hzl 2020/01/05 2:36 PM
	 */
	@GetMapping(value = "/export/excel")
	public void downFileResponse(@RequestParam String fileName, HttpServletResponse response) {

		response.setContentType("application/x-msdownload;charset=utf-8");
		try {
			response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("模版", "utf-8"));
			excuteSqlService.excuteSql(response, ExcuteSqlDO.builder().sqlString("select * from gp_yl").build());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * 填充excel并导出
	 *
	 * @param null
	 * @author hzl 2021-01-29 11:04 AM
	 * @return 
	 */

}
