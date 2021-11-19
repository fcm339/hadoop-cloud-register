package com.hzl.hadoop.workflow.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 流程挂载
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:13
 */
@Data
public class ProcessMountVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */

	private Long id;
	/**
	 * 主流程
	 */

	private Long masterProcessId;
	/**
	 * 子流程
	 */

	private Long childProcessId;
	/**
	 * 挂载节点，被挂载节点需要等待子流程结束，才能结束，尽管可以提前审批
	 */

	private Long nodeId;
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
