package com.hzl.hadoop.app.dataobject;

import lombok.*;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * description
 *
 * @author hzl 2020/11/16 11:35 AM
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "excute_sql")
public class ExcuteSqlDO {

	private Long id;

	//功能名称
	private String name;
	//sql
	private String sqlString;

	@Transient
	private String employeeNum;

	private Date creationDate;

	private Long createdBy;

	private Date lastUpdateDate;

	private Long lastUpdatedBy;

	private Long objectVersionNumber;
}
