package com.hzl.hadoop.gp.vo;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * description
 * 最大最小成交量折线图
 * @author hzl 2020/11/05 10:36 PM
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaxMinVO {
	//折线名称
	private String series;
	//时间
	private LocalTime x;

	//价格
	private BigDecimal y;
}
