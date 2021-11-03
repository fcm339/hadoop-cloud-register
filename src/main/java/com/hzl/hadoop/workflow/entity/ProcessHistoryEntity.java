package com.hzl.hadoop.workflow.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


/**
 * 流程记录
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-03 17:38:26
 */
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
