package com.hzl.hadoop.file.excel.convert.biginteger;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.NumberUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;

/**
 * @description: BigInteger and string converter
 * @author: Chuang Yan
 * @time: 2019/12/9 21:16
 */
public class BigIntegerStringConverter implements Converter<BigInteger> {
    @Override
    public Class supportJavaTypeKey() {
        return BigInteger.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public BigInteger convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
										GlobalConfiguration globalConfiguration) throws ParseException {
        return NumberUtils.parseBigDecimal(cellData.getStringValue(), contentProperty).toBigInteger();
    }

    @Override
    public CellData convertToExcelData(BigInteger value, ExcelContentProperty contentProperty,
									   GlobalConfiguration globalConfiguration) {
        return NumberUtils.formatToCellData(new BigDecimal(value), contentProperty);
    }
}
