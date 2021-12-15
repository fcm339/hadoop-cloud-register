package com.hzl.hadoop.gp.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 个股新闻
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-12-15 11:08:17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GpNewsVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private Long id;
	/**
	 * 新闻来源
	 */
	private String source;
	/**
	 * 股票编号
	 */
	private String gpCode;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 发布时间
	 */
	private LocalDateTime releaseTime;
	/**
	 * 新闻地址
	 */
	private String url;
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
