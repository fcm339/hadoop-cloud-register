package com.hzl.hadoop.hdfs.service;

import com.hzl.hadoop.hdfs.entity.FileDictory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
	 * 创建目录
	 * 会根据请求参数的路径，自动创建子目录
	 *
	 * @param path 路径
	 * @return true成功，false失败
	 * @author hzl 2020-03-13 10:14 AM
	 */
	boolean mkdir(String path) throws IOException;

	/**
	 * 删除目录，或者文件
	 * force是否递归删除其子目录，true会删除，false不会且当发现存在子目录后hdfs会报错提示
	 *
	 * @param path 路径，force是否强制删除子目录。
	 * @return true成功，false失败
	 * @author hzl 2020-03-13 10:14 AM
	 */
	boolean dlDir(String path, boolean force) throws IOException;


	/**
	 * 查询当前目录下的所有文件
	 *
	 * @param path 路径
	 * @return
	 * @author hzl 2020-03-16 4:21 PM
	 */
	List<FileDictory> queryTree(String path) throws IOException;

	/**
	 * 上传文件
	 *
	 * @param path 上传文件的路径  content 文件内容
	 * @return
	 * @author hzl 2020-03-19 6:03 PM
	 */
	boolean uploadFile(String path, InputStream content) throws IOException;

	/**
	 * 下载单个文件
	 *
	 * @param path 下载文件的路径+文件名
	 * @return
	 * @author hzl 2020-03-19 6:04 PM
	 */
	InputStream downloadFile(String path) throws IOException;


	/**
	 * 下载文件夹，文件夹压缩后传递到前台
	 *
	 * @param path 下载文件的路径+文件名
	 * @return
	 * @author hzl 2020-03-19 6:04 PM
	 */
	byte[] downloadFiles(String path) throws IOException;
}
