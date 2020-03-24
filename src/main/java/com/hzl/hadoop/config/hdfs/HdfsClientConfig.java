package com.hzl.hadoop.config.hdfs;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * description
 * hdfs客户端配置
 *
 * @author hzl 2020/03/10 11:28 AM
 */
@Slf4j
@Component
@EnableConfigurationProperties({HdfsConfig.class})
public class HdfsClientConfig {

	private HdfsConfig hdfsConfig;

	/**
	 * @return
	 * @EnableConfigurationProperties({HdfsConfig.class})作用将HdfsConfig注入到spring容器
	 * @author hzl 2020-03-19 4:13 PM
	 */
	public HdfsClientConfig(HdfsConfig hdfsConfig) {
		this.hdfsConfig = hdfsConfig;
	}

	/**
	 * 参数优先级： 1、客户端代码中设置的值 2、classpath下的用户自定义配置文件 3、然后是服务器的默认配置
	 * 方法作用读取配置文件,该配置也可以不进行参数设置只声明对象，让他读取服务器的默认配置
	 *
	 * todo 存在bug当conf不进行任何参数配置是，默认使用服务器上的配置，但是现在尽然没有，通过测试发现副本数量服务器设置为1，但是
	 * 通过 java客户端创建文件确生成了三个副本，用hadoop shell命令直接在服务器上创建确是读取的服务器默认配置生成了一个副本，该问题
	 * 待后续解决，先暂时在java代码里面进行参数配置
	 */
	public Configuration getConf() {
		Configuration conf = new Configuration();
		conf.set("dfs.client.use.datanode.hostname", "true");
		//设置文件副本数量
		conf.set("dfs.replication", "1");
		conf.set("fs.defaultFS", hdfsConfig.getNameNode());
//		conf.set("dfs.name.dir","/usr/local/hadoop/hdfs/name");
//		conf.set("dfs.data.dir","/usr/local/hadoop/hdfs/data");
		//禁用FileSystem的缓存，这样在关闭FileSystem对象后，重新获取就不会出现java.io.IOException: Filesystem closed
		conf.setBoolean("fs.hdfs.impl.disable.cache",true);
		return conf;
	}

	public FileSystem createFileSystem() {
		// 文件系统
		FileSystem fs = null;
		// 返回指定的文件系统,如果在本地测试，需要使用此种方法获取文件系统
		try {
			URI uri = new URI(hdfsConfig.getNameNode().trim());
			fs = FileSystem.get(uri, getConf(), hdfsConfig.getUserName().trim());

		} catch (Exception e) {
			log.error("hdfs生成文件操作对象失败", e);
		}
		return fs;
	}
}
