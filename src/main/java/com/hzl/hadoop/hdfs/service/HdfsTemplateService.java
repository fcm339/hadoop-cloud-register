package com.hzl.hadoop.hdfs.service;

import com.alibaba.fastjson.JSONArray;

import java.io.IOException;

/**
 * description
 * hdfs文件操作模版
 *
 * @author hzl 2020/03/10 12:27 PM
 */
public interface HdfsTemplateService {

	/**
	 * 判断文件或者目录是否存在
	 *
	 * @param path 路径
	 * @return true成功，false失败
	 * @author hzl 2020-03-13 2:05 PM
	 */
	boolean hasDirOrFile(String path) throws IOException;


	/**
	 * 创建目录和文件
	 * 会根据请求参数的路径，自动创建子目录
	 *
	 * @param path 路径
	 * @return true成功，false失败
	 * @author hzl 2020-03-13 10:14 AM
	 */
	boolean mkdir(String path) throws IOException;

	/**
	 * 删除目录
	 * 如果删除的目录存在子目录是无法删除的，必须先删除子目录，当force为true的时候可以强制删除
	 * 当删除文件的时候force值为true和false对结果无影响
	 * @param path 路径，force是否强制删除子目录。
	 * @return true成功，false失败
	 * @author hzl 2020-03-13 10:14 AM
	 */
	boolean dlDir(String path, boolean force) throws IOException;


	/**
	 * 查询当前目录下的所有文件
	 *
	 * @param path 路径
	 * @author hzl 2020-03-16 4:21 PM
	 * @return
	 */
	JSONArray queryTree(String path);
}
