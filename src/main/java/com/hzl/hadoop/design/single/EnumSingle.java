package com.hzl.hadoop.design.single;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * description
 * 枚举实现单例
 *
 * 枚举是 JDK 1.5  中引入的新特性
	 JAVA在枚举的序列化和反序列化做了特殊规定
	 枚举类型及其定义的枚举变量在JVM中都是唯一的

 枚举的构造器只在构造枚举值的时候被调用，构造器私有private，不允许有public构造器

 定义一个枚举的元素SINGLETONE，就代表EnumSingle的一个实例

 所以只定义一个枚举元素

 * @author hzl 2021/09/02 2:15 PM
 */
public enum EnumSingle {

	SINGLETON;

	private Connection connection;

	EnumSingle(){
		String url="";
		try {
			connection= DriverManager.getConnection(url,"","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public Connection getInstance(){
		return connection;
	}
}
