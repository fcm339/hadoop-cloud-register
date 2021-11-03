package com.hzl.hadoop.util;

import java.util.function.Predicate;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

/**
 * description
 * 单纯用来进行测试
 * @author hzl 2021/10/20 10:15 AM
 */
public class TestUtils {

	public static final Integer INTEGER_ONE = 1;

	public static void main(String args[]){
//		String s="11dede-3434dfff-2fff";
//		System.out.println("字符串替换1"+s.replace('-','%'));
//		System.out.println("字符串替换2"+s);
//
//		System.out.println("字符串替换3"+s.replaceAll("-","%"));
//
//		System.out.println("sql拼接"+String.format("%s = {0}", "name"));
//		System.out.println("sql拼接"+String.format("{%s}", "name"));
		Predicate<Integer> predOdd = integer -> integer % 2 == 1;
		System.out.println(predOdd.test(5));

		//System.out.println(APPLICATION_JSON_UTF8.getSubtype());
	}

}
