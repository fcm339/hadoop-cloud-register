package com.hzl.hadoop.app.dataobject;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * 合同基本信息
 *
 * @author chunqiang.bai@hand-china.com
 * @date 2018/06/14
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractDO {
	//jpa注解
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contractNumber;
	private String contractName;
	private Long companyId;
	private String companyName;
	private Long categoryId;
	private String categoryName;
	private String inOutTypeCode;
	private String propertyCode;
	private String departmentName;
	private Long departmentId;
	private String belongingDepartmentName;
	private Long belongingDepartmentId;
	private LocalDate signatureDate;
	private LocalDate startDate;
	private LocalDate endDate;
	private BigDecimal amount;
	private String paymentModeCode;
	private String signatureTypeCode;
	private String currency;
	private String principalName;
	private Long principalId;
	private String statusCode;
	private String executeStatusCode;
	private String lastStatusCode;
	private String description;
	private String creationMethodCode;
	private Long sourceContractId;
	private String sourceContractNumber;
	private Long sourceTemplateId;
	private String sourceTemplateNumber;
	private Long contentId;
	private Long lineFieldId;
	private String creator;
	private Date creationDate;
	private Long version;
	private String editMode;
	private Long tenantId;
	/**
	 * 永升增加字段 税率
	 */
	private String tax;

	/**
	 * 永升增加字段  税率ID
	 */
	private Long taxId;

	/**
	 * 动态字段编码
	 */
	private Long ruleId;

	/**
	 * 永升增加字段 水印下拉框
	 */
	private String watermarkId;

	/**
	 * 永升增加字段 其他水印
	 */
	private String watermarkName;
	/**
	 * 永升增加字段 印花税率
	 */
	private BigDecimal stampTax;

	/**
	 * 永升增加字段 印花税税额
	 */
	private BigDecimal stampTaxAmount;

	/**
	 * 永升增加字段 是否标准合同 0：非标准合同；1：标准合同
	 */
	private Long standardType;
	// 存储ekp的流程id
	private String instanceId;
	private String url;

	private Boolean hasSupplementaryAgreement;


	// qjs文档新增
	private Boolean isCustomer;
	// 项目信息
	private String projectCode;

	private String projectName;
	// 签约主体

	private String contractPartyName;

	private String contractPartyCode;
	// 付款方式
	private String payMethodD;
	// 合同单价
	private BigDecimal contractPriceD;
	// 单价单位
	private String priceUnitD;
	// 纸制合同编号
	private String paperNumberD;
	// 成本中心id
	private Long costCenterId;
	private String costCenterName;
	// 收费项
	private String receviceD;
	// 集团区域
	private String areaD;
	// 发票类型
	private String invoiceTypeD;
	// 合约规划id存储到数据库

	private Long planId;

	// 合约规划编号
	private String planNumber;
	// 合约规划金额
	private BigDecimal planMoney;
	// 合约规划余额
	private BigDecimal planBalance;
	// qjs结束

	//项目业态
	private String projectOperation;

	// 收费项名称
	private String receviceName;

	// 是否关联方
	private Boolean flag;

	// 其他特殊条款约定
	private String otherSpecialTerms;

	private String remark;
	//非数据库字段
	@Transient
	private String sss;
}
