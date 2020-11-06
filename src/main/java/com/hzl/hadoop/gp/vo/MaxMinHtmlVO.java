package com.hzl.hadoop.gp.vo;

import lombok.*;

import java.math.BigDecimal;

/**
 * description
 * 最大最小金额波动，html模版变量
 * @author hzl 2020/11/05 11:58 PM
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaxMinHtmlVO {
	String data;

	String gpName;

	//当前价格和最低价格的百分比
	String currentMin;
	//当前价格和最高价格的百分比
	String currentMax;
	//当前价格和开盘价的百分比
	String currentInit;

	//当前价格和昨日收盘的百分比
	String currentYesterday;

	//今日开盘价和昨日收盘价的百分比
	String initYesterday;

	//开盘价
	private BigDecimal initPrice;
	//当前价
	private BigDecimal currentPrice;
	//最高价
	private BigDecimal maxPrice;
	//最低价
	private BigDecimal minPrice;

	//昨日收盘价
	private BigDecimal yesterdayEndPrice;


}
