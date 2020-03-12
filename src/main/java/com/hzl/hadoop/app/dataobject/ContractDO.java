package com.hzl.hadoop.app.dataobject;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 *
 * @date 2018/06/14
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "hcbm_contract")
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
	//DateTimeFormat该注解指定入参格式
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//该注解指定出参格式，使用该注解的原因是springmvc的消息转换器用的是阿里的json包
	@JSONField(format = "yyyy/MM/dd")
	private LocalDate signatureDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd")
	private LocalDate startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd")
	private LocalDateTime endDate;
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
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
	private Date creationDate;
	private Long version;
	private String editMode;
	private Long tenantId;
	//使用改注解表示非数据库字段
	@Transient
	private String ss;
}
