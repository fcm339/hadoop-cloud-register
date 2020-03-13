package com.hzl.hadoop.config.hdfs;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.net.URI;

/**
 * description
 * hdfs客户端配置
 *
 * @author hzl 2020/03/10 11:28 AM
 */
@Slf4j
@org.springframework.context.annotation.Configuration
@ConditionalOnProperty(name = "hadoop.hdfs.name-node")
@EnableConfigurationProperties({HdfsConfig.class})
public class HdfsClientConfig {


	@Bean("fileSystem")
	public FileSystem createFs(HdfsConfig hdfsConfig) {
		//读取配置文件,该配置也可以不进行参数设置只声明对象，让他读取服务器的默认配置
		Configuration conf = new Configuration();

		/**
		 * 参数优先级： 1、客户端代码中设置的值 2、classpath下的用户自定义配置文件 3、然后是服务器的默认配置
		 * 作用自行百度
		 */

		/*conf.set("dfs.replication", "1");
		conf.set("fs.defaultFS", hdfsConfig.getNameNode());
		*/

		// 文件系统
		FileSystem fs = null;
		// 返回指定的文件系统,如果在本地测试，需要使用此种方法获取文件系统
		try {

			//如果这样去获取，那conf里面就可以不要配"fs.defaultFS"参数，而且，这个客户端的身份标识已经是hadoop用户
			/*
				URI uri = new URI(hdfsConfig.getNameNode().trim());
				fs = FileSystem.get(uri, conf, "hadoop");
			*/
			fs = FileSystem.get(conf);
		} catch (Exception e) {
			log.error("hdfs生成文件操作对象失败", e);
		}
		return fs;
	}
}
