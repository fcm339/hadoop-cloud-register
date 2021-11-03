package com.hzl.hadoop.workflow.vo;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 审批节点
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
@Data
public class ApproveNodeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private Integer id;
	/**
	 * 节点编号
	 */
	private Long nodeNum;
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
	 * 开始节点id
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
	private Date createTime;
	/**
	 * 最后更新人
	 */
	private Long updateBy;
	/**
	 * 最后更新时间
	 */
	private Date updateTime;
	/**
	 * 版本号
	 */
	private Integer versionNum;

}
