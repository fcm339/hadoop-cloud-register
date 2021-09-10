package com.hzl.hadoop.security.dataobject;

import com.hzl.hadoop.constant.BaseDO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * description
 *
 * @author hzl 2021/09/09 5:11 PM
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "sys_user")
public class SysUser extends BaseDO {

	@Id
	@Column(name = "id")
	//主键由数据库生成
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String password;
//
//	private LocalDateTime creationDate;
//
//	private Long createdBy;
//
//	private LocalDateTime lastUpdateDate;
//
//	private Long lastUpdatedBy;
//
//	private Long objectVersionNumber;


}
