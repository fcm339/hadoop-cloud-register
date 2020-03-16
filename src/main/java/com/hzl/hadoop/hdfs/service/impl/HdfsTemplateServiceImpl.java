package com.hzl.hadoop.hdfs.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.hzl.hadoop.hdfs.service.HdfsTemplateService;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * description
 *
 * @author hzl 2020/03/10 12:27 PM
 */
@Service
public class HdfsTemplateServiceImpl implements HdfsTemplateService {

	FileSystem fileSystem;

	public HdfsTemplateServiceImpl(FileSystem fileSystem) {
		this.fileSystem = fileSystem;
	}

	@Override
	public boolean hasDirOrFile(String path) throws IOException {
		if (StringUtils.isEmpty(path)) {
			return false;
		}
		FileSystem fs = fileSystem;
		Path srcPath = new Path(path);
		boolean isExists = fs.exists(srcPath);
		return isExists;

	}

	@Override
	public boolean mkdir(String path) throws IOException {
		if (StringUtils.isEmpty(path)) {
			return false;
		}
		if (hasDirOrFile(path)) {
			return true;
		}
		FileSystem fs = fileSystem;
		// 目标路径
		Path srcPath = new Path(path);
		boolean isOk = fs.mkdirs(srcPath);
		//IOUtils.closeStream(fs);
		return isOk;

	}

	@Override
	public boolean dlDir(String path, boolean force) throws IOException {
		if (StringUtils.isEmpty(path)) {
			return false;
		}
		if (!hasDirOrFile(path)) {
			return false;
		}
		FileSystem fs = fileSystem;
		Path srcPath = new Path(path);
		boolean isOk = false;
		if (force) {
			//true的时候如果删除的是目录，则当前目录的子目录也会删除，如果是文件则只会删除当前文件
			isOk = fs.delete(srcPath,force);
		} else {
			isOk = fs.deleteOnExit(srcPath);
		}
		//fs.close();
		return isOk;
	}

	//todo 明天继续完善hdfs的文件操作
	@Override
	public JSONArray queryTree(String path) {
		return null;
	}


}
