package com.hzl.hadoop.gp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * description
 *
 * @author hzl 2021/12/15 9:21 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XlNewsVO {

	/**
	 *新闻发布时间
	 * */
	LocalDateTime releaseTime;

	/**
	 *新闻标题
	 * */
	String title;

	/**
	*新闻地址
	* */
	String url;


	/**
	 *新闻爬取时间
	 * */
	String createTime;

	/**
	 * 新闻来源
	 */
	private String source;

}
