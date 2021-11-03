package com.hzl.hadoop.workflow.vo;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 审批节点类型
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
@Data
public class WorkflowNodeTypeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		private Long id;
	/**
	 * 节点编号
	 */
	private String nodeNum;
	/**
	 * 节点名称
	 */
	private String nodeName;
	/**
	 * 节点类型,1:开始节点 2:网关节点  3:审批节点 4结束节点
	 */
	private Integer nodeType;
	/**
	 * 节点描述
	 */
	private String nodeDetail;
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
