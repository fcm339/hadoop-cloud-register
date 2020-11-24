package com.hzl.hadoop.file.excel.convert.biginteger;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.math.BigInteger;

/**
 * @description: BigInteger and boolean converter
 * @author: Chuang Yan
 * @time: 2019/12/9 21:16
 */
public class BigIntegerBooleanConverter implements Converter<BigInteger> {
    @Override
    public Class supportJavaTypeKey() {
        return BigInteger.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.BOOLEAN;
    }

    @Override
    public BigInteger convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
										GlobalConfiguration globalConfiguration) {
        if (cellData.getBooleanValue()) {
            return BigInteger.ONE;
        }
        return BigInteger.ZERO;
    }

    @Override
    public CellData convertToExcelData(BigInteger value, ExcelContentProperty contentProperty,
									   GlobalConfiguration globalConfiguration) {
        if (BigInteger.ONE.equals(value)) {
            return new CellData(Boolean.TRUE);
        }
        return new CellData(Boolean.FALSE);
    }
}
