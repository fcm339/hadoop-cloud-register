package com.hzl.hadoop.config.hdfs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * description
 *
 * @author hzl 2020/03/13 9:58 AM
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "hadoop.hdfs")
public class HdfsConfig {

	/*
	获取hdfs的nameNode节点的ip地址
	*/
	private String nameNode;

	/*hdfs启动的用户*/
	private String userName;

}
