package com.hzl.hadoop.design.single;

/**
 * description
 * 饿汉模式
 * @author hzl 2021/09/02 11:31 AM
 */
public class HungrySingle {

	//static保证是类加载的时候创建，且唯一。final保证对象不可变
	private static HungrySingle hungrySingle =new HungrySingle();

	//私有构造，保证除了本类其他类中无法new该对象
	private HungrySingle() {
	}

	//提供
	public static HungrySingle getInstance(){

		return hungrySingle;
	}



}
