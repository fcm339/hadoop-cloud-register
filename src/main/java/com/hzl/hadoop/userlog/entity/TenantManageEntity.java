package com.hzl.hadoop.userlog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@TableName("tenant_manage")
public class TenantManageEntity {

	/**
	 *管理员的租户id为1
	 */
	@TableId(type = IdType.AUTO)
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
	@TableField(fill = FieldFill.INSERT)
	private Long createBy;
	/**
	 *
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;
	/**
	 *
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updateBy;
	/**
	 *
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
	/**
	 *
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer versionNum;

}
