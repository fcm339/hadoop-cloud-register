package com.hzl.hadoop.interfacemanager.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-16 14:05:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("interface_manage")
public class InterfaceManageEntity {

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 接口地址
	 */
	private String url;
	/**
	 * 请求方式
	 */
	private String method;
	/**
	 * 是否需要登陆认证
	 */
	private Boolean isLogin;

	/**
	 * 接口描述
	 */
	private String description;

	/**
	 * 服务名称
	 */
	private String serviceName;

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
