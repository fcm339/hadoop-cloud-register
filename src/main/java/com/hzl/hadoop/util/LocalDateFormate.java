package com.hzl.hadoop.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description
 *日期格式化工具
 * @author hzl 2020/01/03 4:59 PM
 */
public class LocalDateFormate {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * <p>
	 * 将字符串的LocalDate类型日期，转换成LocalDate类型
	 * </p>
	 * 
	 * @author hzl 2020/01/03 5:17 PM
	 */
	public static LocalDate localDateFormate(String localDate){
		if(StringUtils.isEmpty(localDate)){
			return null;
		}else{
			LocalDate localDateConvert = LocalDate.parse(localDate, formatter);
			return localDateConvert ;
		}

	}

	/**
	 * <p>
	 * @Description localDateTime转换成string
	 * @param date 时间
	 * @param type 样式
	 * </p>
	 *
	 * @author hzl 2020/01/16 10:22 AM
	 */
	public static String localDateTimeToString(LocalDateTime date, String type) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(type);
		return date.format(formatter);
	}
}
