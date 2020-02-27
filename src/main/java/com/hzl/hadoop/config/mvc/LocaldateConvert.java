package com.hzl.hadoop.config.mvc;

import com.hzl.hadoop.util.LocalDateFormate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * description
 * 参考DateFormatterRegistrar，springmvc没有定义java8日期类型的转换，前台传时间类型绑定到请求方法的参数时，如果参数类型为localdate会报错
 * 作用：将前端日期字符串转换成java日期类型
 * @author hzl 2020/01/20 4:52 PM
 */
@Slf4j
public class LocaldateConvert implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String s) {
		return LocalDateFormate.localDateFormate(s);
	}

	public static class StringToLocaldatetimeConvert implements Converter<String, LocalDateTime> {

		public StringToLocaldatetimeConvert() {
		}

		@Override
		public LocalDateTime convert(String s) {
			return LocalDateFormate.stringTolocalDateTime(s);
		}
	}

	public static class StringToDateConvert implements Converter<String, Date> {

		public StringToDateConvert() {
		}

		@Override
		public Date convert(String s) {
			log.info("前端收到的日期类型"+s);
			return LocalDateFormate.localStringToDate(s);
		}
	}
}
