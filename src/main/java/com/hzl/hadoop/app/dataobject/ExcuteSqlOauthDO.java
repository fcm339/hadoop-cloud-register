package com.hzl.hadoop.app.dataobject;

import lombok.*;

import javax.persistence.Table;
import java.util.Date;

/**
 * description
 *
 * @author hzl 2020/11/16 11:42 AM
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "excute_sql_oauth")
public class ExcuteSqlOauthDO {
	private Long id;
	//sql
	private Long sqlId;
	//员工编号
	private String employeeNum;

	private Date creationDate;

	private Long createdBy;

	private Date lastUpdateDate;

	private Long lastUpdatedBy;

	private Long objectVersionNumber;

}
