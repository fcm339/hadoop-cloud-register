package com.hzl.hadoop.file.excel.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * description
 * excel转换的对象，这个是父类其他的类继承该类
 * @author hzl 2020/01/14 4:12 PM
 */
@Data
public class ExcelData {
	/**
	 * 用名字去匹配，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
	 */
	@ExcelProperty("字符串标题")
	private String string;
	/**
	 * 强制读取第二个 这里不建议 index 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配
	 */
	@ExcelProperty(index = 1)
	private Date date;
	@ExcelProperty(index = 2)
	private Double doubleData;
}
