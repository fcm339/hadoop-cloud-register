package com.hzl.hadoop.workflow.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 流程记录
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@Data
public class ProcessHistoryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */

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

	/**
	 * 流程状态1，启动，2:审批中，3驳回，4驳回指定节点，5审批通过
	 */
	private Integer processStatus;
}
