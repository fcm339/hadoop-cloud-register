package com.hzl.hadoop.file.excel.convert.localdatetime;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.DateUtils;
import com.alibaba.excel.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Date and string converter
 *
 * @author Jiaju Zhuang
 */
@Slf4j
public class SqlDateStringConverter implements Converter<Date> {
	@Override
	public Class supportJavaTypeKey() {
		return Date.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public Date convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
								  GlobalConfiguration globalConfiguration) throws ParseException {
		if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
			return strToDate(cellData.getStringValue(), null);
		} else {
			return strToDate(cellData.getStringValue(),
					contentProperty.getDateTimeFormatProperty().getFormat());
		}
	}

	@Override
	public CellData convertToExcelData(Date value, ExcelContentProperty contentProperty,
									   GlobalConfiguration globalConfiguration) {
		if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
			return new CellData(DateUtils.format(value, null));
		} else {
			return new CellData(DateUtils.format(value, contentProperty.getDateTimeFormatProperty().getFormat()));
		}
	}

	public static java.sql.Date strToDate(String strDate, String dateformat) {
		String str = strDate;
		SimpleDateFormat format = new SimpleDateFormat(StringUtils.isEmpty(dateformat) ? "yyyy-MM-dd" : dateformat);
		java.util.Date d = null;
		try {
			d = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date date = new java.sql.Date(d.getTime());
		return date;
	}
}
