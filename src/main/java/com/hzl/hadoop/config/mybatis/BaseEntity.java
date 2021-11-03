package com.hzl.hadoop.config.mybatis;

import java.util.Date;

/**
 * description
 *
 * @author hzl 2021/11/02 1:47 PM
 */
public class BaseEntity {

	public BaseEntity(Long createBy, Date createTime, Long updateBy, Date updateTime, Integer versionNum) {
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
		this.versionNum = versionNum;
	}

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
