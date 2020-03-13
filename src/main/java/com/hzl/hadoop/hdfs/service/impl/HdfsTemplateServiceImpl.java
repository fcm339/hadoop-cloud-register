package com.hzl.hadoop.hdfs.service.impl;

import com.hzl.hadoop.hdfs.service.HdfsTemplateService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;

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
	public boolean hasDirOrFile() {
		return false;
	}

	@Override
	public void mkdir(String path) {

	}

	@Override
	public void dlDir(String path) {

	}

	//todo bug待修复测试，修复后可以进行标准接口的开发
	public static void main(String args[]) {
		Configuration conf = new Configuration();
		InputStream inputStream = null;
		try {
			conf.set("dfs.replication", "1");

			FileSystem fs = FileSystem.get(new URI("hdfs://localhost:9000"), conf, "root");
			inputStream = fs.open(new Path("/ship.txt"));
			IOUtils.copyBytes(inputStream, System.out, 4096, false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeStream(inputStream);
		}
	}
}
