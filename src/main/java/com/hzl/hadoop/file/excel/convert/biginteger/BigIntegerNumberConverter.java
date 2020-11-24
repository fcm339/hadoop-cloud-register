package com.hzl.hadoop.file.excel.convert.biginteger;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @description: BigInteger and number converter
 * @author: Chuang Yan
 * @time: 2019/12/9 20:27
 */
public class BigIntegerNumberConverter implements Converter<BigInteger> {
    @Override
    public Class supportJavaTypeKey() {
        return BigInteger.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.NUMBER;
    }

    @Override
    public BigInteger convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
										GlobalConfiguration globalConfiguration) {
        return cellData.getNumberValue().toBigInteger();
    }

    @Override
    public CellData convertToExcelData(BigInteger value, ExcelContentProperty contentProperty,
									   GlobalConfiguration globalConfiguration) {
        return new CellData(new BigDecimal(value));
    }
}
