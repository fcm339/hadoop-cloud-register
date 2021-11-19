package com.hzl.hadoop.workflow.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 开始节点
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 18:55:14
 */
@Data
public class StartNodeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */

	private Long id;
	/**
	 * 流程描述
	 */
	private String processDescribe;
	/**
	 * 节点编号
	 */

	private String nodeNum;
	/**
	 * 审批人
	 */

	private Long approverId;
	/**
	 * 审批组（全组同意，或者任意一人同意）
	 */

	private Long approverGroupId;
	/**
	 * 指定岗位编号
	 */

	private String positionNum;
	/**
	 * 下一节点（一对一，可以是网管，审批节点）
	 */

	private Long nextNodeId;
	/**
	 * 下一节点类型（关联审批节点表的node_type）
	 */

	private Integer nextNodeType;
	/**
	 * 全局监听（监听所有节点的类）
	 */

	private String globalListen;
	/**
	 * 是否邮件通知提交人和下一节点审批人，如果不满足可以通过监听个性化
	 */

	private Integer isMailNotify;
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
