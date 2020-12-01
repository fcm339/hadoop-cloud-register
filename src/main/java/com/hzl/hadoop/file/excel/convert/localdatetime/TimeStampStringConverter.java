package com.hzl.hadoop.file.excel.convert.localdatetime;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @description: BigInteger and string converter
 * @author: Chuang Yan
 * @time: 2019/12/9 21:16
 */
@Slf4j
public class TimeStampStringConverter implements Converter<Timestamp> {

	@Override
	public Class supportJavaTypeKey() {
		return Timestamp.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public Timestamp convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
		return Timestamp.valueOf(cellData.getStringValue());

	}

	@Override
	public CellData convertToExcelData(Timestamp value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//方法一
		tsStr = sdf.format(value);
		return new CellData(tsStr);

	}
}
