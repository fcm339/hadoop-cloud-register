package com.hzl.hadoop.workflow.vo;


import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 审批节点审批历史
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-04 14:56:39
 */
@Data
public class ApproveHistoryApproverVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
private Long id;
	/**
	 * 流程记录id
	 */
private Long processId;
	/**
	 * 当前节点id
	 */
private Long currentNodeId;
	/**
	 * 当前节点类型
	 */
private Integer currentNodeType;
	/**
	 * 下一节点id
	 */
private Long nextNodeId;
	/**
	 * 下一节点类型
	 */
private Integer nextNodeType;
	/**
	 * 审批人
	 */
private String approverNum;
	/**
	 * 审批动作，1同意，2拒绝，3跳过，4转交
	 */
private Long approveAction;
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
