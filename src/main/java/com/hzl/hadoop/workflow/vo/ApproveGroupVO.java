package com.hzl.hadoop.workflow.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 审批组
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@Data
public class ApproveGroupVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */

	private Long id;
	/**
	 * 审批组名称
	 */

	private String groupName;
	/**
	 * 审批组编号
	 */

	private String groupNum;
	/**
	 * 审批类型，任意一人同意true，或者多人全部统一false
	 */

	private Integer approveType;
	/**
	 * 租户id
	 */

	private Long tenantId;
	/**
	 * 创建人
	 */

	private Long createBy;
	/**
	 * 创建时间
	 */

	private LocalDateTime createTime;
	/**
	 * 最后更新人
	 */

	private Long updateBy;
	/**
	 * 最后更新时间
	 */

	private LocalDateTime updateTime;
	/**
	 * 版本号
	 */

	private Integer versionNum;

}
