package com.hzl.hadoop.userlog.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 租户管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-19 16:18:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantManageVO{

	/**
	 *
	 */
	private Long id;
	/**
	 *
	 */
	private String tenantName;
	/**
	 *
	 */
	private LocalDateTime periodFrom;
	/**
	 *
	 */
	private LocalDateTime periodTo;
	/**
	 *
	 */
	private Long createBy;
	/**
	 *
	 */
	private LocalDateTime createTime;
	/**
	 *
	 */
	private Long updateBy;
	/**
	 *
	 */
	private LocalDateTime updateTime;
	/**
	 *
	 */
	private Integer versionNum;

}
