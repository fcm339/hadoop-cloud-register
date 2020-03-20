package com.hzl.hadoop.hdfs.service.impl;

import com.hzl.hadoop.config.hdfs.HdfsClientConfig;
import com.hzl.hadoop.constant.FileConstant;
import com.hzl.hadoop.exception.CommonException;
import com.hzl.hadoop.hdfs.entity.FileDictory;
import com.hzl.hadoop.hdfs.service.HdfsTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.hzl.hadoop.util.LocalDateFormate.longToLocalDateTime;

/**
 * description
 *
 * @author hzl 2020/03/10 12:27 PM
 */
@Slf4j
@Service
public class HdfsTemplateServiceImpl implements HdfsTemplateService {

	HdfsClientConfig hdfsClientConfig;

	public HdfsTemplateServiceImpl(HdfsClientConfig hdfsClientConfig) {
		this.hdfsClientConfig = hdfsClientConfig;
	}

	@Override
	public boolean hasDirOrFile(String path) throws IOException {
		if (StringUtils.isEmpty(path)) {
			return false;
		}

		FileSystem fs = hdfsClientConfig.createFileSystem();
		log.info("FileSystem对象" + fs.toString() + fs.hashCode());
		Path srcPath = new Path(path);
		boolean isExists = fs.exists(srcPath);
		return isExists;

	}

	@Override
	public boolean mkdir(String path) throws IOException {
		if (StringUtils.isEmpty(path)) {
			throw new CommonException("查询参数为空");
		}

		FileSystem fs = hdfsClientConfig.createFileSystem();
		// 目标路径
		Path srcPath = new Path(path);
		boolean isOk = fs.mkdirs(srcPath);
		IOUtils.closeStream(fs);
		return isOk;

	}

	@Override
	public boolean dlDir(String path, boolean force) throws IOException {
		if (StringUtils.isEmpty(path)) {
			throw new CommonException("查询参数为空");
		}
		if (!hasDirOrFile(path)) {
			throw new CommonException("查询的文件夹或者文件不存在");
		}
		FileSystem fs = hdfsClientConfig.createFileSystem();
		Path srcPath = new Path(path);
		boolean isOk = false;

		//true的时候如果删除的是目录，则当前目录的子目录也会删除，如果是文件则只会删除当前文件
		try {
			isOk = fs.delete(srcPath, force);
		} catch (PathIsNotEmptyDirectoryException emptyDirectoryException) {
			throw new CommonException("存在子目录,可选择强制删除!");
		}
		/*当FileSystem关闭时，删除指定的文件
		isOk = fs.deleteOnExit(srcPath);*/
		IOUtils.closeStream(fs);
		return isOk;
	}

	@Override
	public List<FileDictory> queryTree(String path) throws IOException {
		if (StringUtils.isEmpty(path)) {
			throw new CommonException("查询参数为空");
		}
		if (!hasDirOrFile(path)) {
			throw new CommonException("查询的文件夹或者文件不存在");
		}
		FileSystem fs = hdfsClientConfig.createFileSystem();
		Path srcPath = new Path(path);
		FileStatus[] listStatus = fs.listStatus(srcPath);
		log.info("目录结构" + listStatus.toString());
		List<FileDictory> fileDictories = new ArrayList<>();
		if (listStatus != null && listStatus.length > 0) {
			for (FileStatus fileStatus : listStatus) {
				fileDictories.add(FileDictory.builder()
						.fileName(fileStatus.getPath().getName())
						.size(fileStatus.getBlockSize())
						.fileType(fileStatus.isDirectory())
						.creatDate(longToLocalDateTime(fileStatus.getModificationTime()))
						.access_time(longToLocalDateTime(fileStatus.getAccessTime()))
						.replication(fileStatus.getReplication())
						.owner(fileStatus.getOwner())
						.group(fileStatus.getGroup())
						.build());
			}
		}
		return fileDictories;
	}

	@Override
	public boolean uploadFile(String path, InputStream content) throws IOException {
		//先判断路径是否存在
		if (StringUtils.isEmpty(path)) {
			throw new CommonException("查询参数为空");
		}

		FileSystem fs = hdfsClientConfig.createFileSystem();
		Path srcPath = new Path(path);

		FSDataOutputStream outputStream = fs.create(srcPath);
		IOUtils.copyBytes(content, outputStream, FileConstant.bufferSize);
		IOUtils.closeStream(content);
		IOUtils.closeStream(outputStream);
		IOUtils.closeStream(fs);
		return true;
	}

	@Override
	public InputStream downloadFile(String path) throws IOException {
		//先判断文件是否存在
		if (StringUtils.isEmpty(path)) {
			throw new CommonException("查询参数为空");
		}
		FileSystem fs = hdfsClientConfig.createFileSystem();
		Path srcPath = new Path(path);
		FSDataInputStream inputStream = fs.open(srcPath);
		log.info("文件下载测试"+inputStream.toString());
		return inputStream;
	}

	@Override
	public byte[] downloadFiles(String path) throws IOException {
		return new byte[0];
	}


}
