package com.hzl.hadoop.app.vo;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * description
 * 付款单实体类
 * @author hzl 2020/01/03 7:49 PM
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentVO {

	private String barcodeImg;

	private String barcode;

	private String userName;

	private LocalDate submitDate;

	private String deptName;

	private String reimReason;

	private List<HashMap> receiptList;

	private BigDecimal money;

}
