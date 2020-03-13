package com.hzl.hadoop.hdfs.service;

/**
 * description
 * hdfs文件操作模版
 * @author hzl 2020/03/10 12:27 PM
 */
public interface HdfsTemplateService {

	/**
	 * 创建目录
	 *
	 * @param null
	 * @author hzl 2020-03-13 10:14 AM
	 * @return 
	 */
	void mkdir(String path);
	
	/**
	 * 删除目录
	 *
	 * @param null
	 * @author hzl 2020-03-13 10:14 AM
	 * @return 
	 */
	void dlDir(String path);
	
	
	
}
