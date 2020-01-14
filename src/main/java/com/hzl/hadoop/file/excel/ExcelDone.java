package com.hzl.hadoop.file.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.hzl.hadoop.file.excel.dto.ExcelData;
import com.hzl.hadoop.file.excel.listener.ExcelDataListener;

/**
 * description
 * excel生成和解析类
 * @author hzl 2020/01/14 4:24 PM
 */
public class ExcelDone {

	/**
	 * <p>
	 * 读取excel
	 * @param excelData excel
	 * </p>
	 *
	 * @author hzl 2020/01/14 3:38 PM
	 */
	public static void readExcel(ExcelData excelData,ExcelDataListener excelDataListener){
		// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
		// 写法1：
		String fileName = "";
		// 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
		EasyExcel.read(fileName, excelData.getClass(),excelDataListener).sheet().doRead();

		// 写法2：
		fileName = "";
		ExcelReader excelReader = EasyExcel.read(fileName, excelData.getClass(), excelDataListener).build();
		ReadSheet readSheet = EasyExcel.readSheet(0).build();
		excelReader.read(readSheet);
		// 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
		excelReader.finish();
	}

	/**
	 * <p>
	 * 生成excel
	 * </p>
	 *
	 * @author hzl 2020/01/14 3:38 PM
	 */
	public static void createExcel(){

	}

}
