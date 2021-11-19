package com.hzl.hadoop.workflow.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;


/**
 * 流程记录
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@Builder
@Data
@TableName("process_history")
public class ProcessHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 提交人
	 */
	private String submitPerson;
	/**
	 * 当前审批人
	 */
	private String currentApproveUser;
	/**
	 * 开始节点id（用于关联他的审批流程图）
	 */
	private Long startId;
	/**
	 * 租户id
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long tenantId;
	/**
	 * 创建人
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long createBy;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;
	/**
	 * 最后更新人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updateBy;
	/**
	 * 最后更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
	/**
	 * 版本号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer versionNum;

}
