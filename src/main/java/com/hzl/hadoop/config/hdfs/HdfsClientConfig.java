package com.hzl.hadoop.config.hdfs;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
public class HdfsClientConfig {
	//获取hdfs的nameNode节点的ip地址
	@Value("${hadoop.hdfs.name-node}")
	private String nameNode;



	/**
	 * Configuration conf=new Configuration（）；
	 * 创建一个Configuration对象时，其构造方法会默认加载hadoop中的两个配置文件，
	 * 分别是hdfs-site.xml以及core-site.xml，这两个文件中会有访问hdfs所需的参数值，
	 * 主要是fs.default.name，指定了hdfs的地址，有了这个地址客户端就可以通过这个地址访问hdfs了。
	 * 即可理解为configuration就是hadoop中的配置信息。
	 *
	 * @return
	 */
	@Bean("fileSystem")
	public FileSystem createFs() {
		//读取配置文件
		Configuration conf = new Configuration();

		/**
		 * 参数优先级： 1、客户端代码中设置的值 2、classpath下的用户自定义配置文件 3、然后是服务器的默认配置
		 * 作用自行百度
		 */

		conf.set("dfs.replication", "1");

		/*
		 构造一个配置参数对象，设置一个参数：我们要访问的hdfs的URI
		 从而FileSystem.get()方法就知道应该是去构造一个访问hdfs文件系统的客户端，以及hdfs的访问地址
		 new Configuration();的时候，它就会去加载jar包中的hdfs-default.xml
		 然后再加载classpath下的hdfs-site.xml
		 */
		conf.set("fs.defaultFS", nameNode);


		// 文件系统
		FileSystem fs = null;
		// 返回指定的文件系统,如果在本地测试，需要使用此种方法获取文件系统
		try {

			//如果这样去获取，那conf里面就可以不要配"fs.defaultFS"参数，而且，这个客户端的身份标识已经是hadoop用户
			//URI uri = new URI(nameNode.trim());
			// fs = FileSystem.get(uri, conf, "hadoop");

			fs = FileSystem.get(conf);
		} catch (Exception e) {
			log.error("", e);
		}
		log.info("fs.defaultFS: " + conf.get("fs.defaultFS"));
		return fs;
	}
}
