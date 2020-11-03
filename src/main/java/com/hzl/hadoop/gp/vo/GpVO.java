package com.hzl.hadoop.gp.vo;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * description
 *
 * @author hzl 2020/11/03 11:35 AM
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GpVO {

	private Long id;
	//股票名称
	private String gpName;
	//开盘价
	private BigDecimal initPrice;
	//当前价
	private BigDecimal currentPrice;
	//最高价
	private BigDecimal maxPrice;
	//最低价
	private BigDecimal minPirce;
	//成交额
	private BigDecimal turnover;
	//成交数
	private Long number;
	//创建时间
	private LocalDateTime createdDate;
	//昨日收盘价
	private BigDecimal yesterdayEndPrice;
}
