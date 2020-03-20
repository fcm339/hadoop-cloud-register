package com.hzl.hadoop.hdfs.entity;

import lombok.*;

import java.time.LocalDateTime;

/**
 * description
 * 文件目录结构对象
 * FileStatus类的映射
 * @author hzl 2020/03/19 4:40 PM
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileDictory {

	//文件名称
	private String fileName;

	//===============================================================================
	//  false表示类型文件，true表示类型为文件夹
	//===============================================================================
	private boolean fileType;

	//文件大小
	private long size;

	//创建时间
	private LocalDateTime creatDate;
	// 所有者
	private String owner;
	// 所在组
	private String group;
	// 访问时间
	private LocalDateTime access_time;
	// 块的复本数
	private short replication;

}
