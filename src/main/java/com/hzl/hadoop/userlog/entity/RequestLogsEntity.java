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
 * 请求日志
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-19 16:18:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("request_logs")
public class RequestLogsEntity{

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 *
	 */
	private String ip;
	/**
	 *
	 */
	private String url;
	/**
	 *
	 */
	private String requestParam;
	/**
	 *操作类型
	 */
	private String method;
	/**
	 *
	 */
	private String response;
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
