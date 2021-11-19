package com.hzl.hadoop.userlog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tenant_manage")
public class TenantManageEntity {

	/**
	 *
	 */
	@TableId
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
