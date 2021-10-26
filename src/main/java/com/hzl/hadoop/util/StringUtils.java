package com.hzl.hadoop.util;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 * 字符串工具类
 *
 * @author hzl 2021/10/25 11:36 AM
 */
public class StringUtils {

	/**
	 * 判断字符串中是否存在指定长度的数字
	 *
	 * @param str  字符串
	 * @param size 数字的位数
	 * @return
	 * @author hzl 2021-10-25 11:37 AM
	 */
	public static boolean hasFixNum(String str, int size) {
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			int chr = str.charAt(i);
			if (chr >= 48 && chr <= 57) {
				++j;
				if (j == size) {
					return true;
				}
			}else{
				//重置，不然不连续的数字也会计算进去
				j=0;
			}
		}
		return false;
	}


	/**
	 * 判断字符串中是否存在指定长度的数字，找出并返回
	 *
	 * @param str  字符串
	 * @param size 数字的位数
	 * @return
	 * @author hzl 2021-10-25 11:37 AM
	 */
	public static List<String> hasFixNumStringReturn(String str, int size) {
		int j = 0;
		List<String> resutl=new ArrayList();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int chr = str.charAt(i);
			if (chr >= 48 && chr <= 57) {
				++j;
				System.out.println(str.charAt(i));
				stringBuilder.append(str.charAt(i));
				if (j == size) {
					resutl.add(stringBuilder.toString());
					//重置，不然不连续的数字也会计算进去
					stringBuilder.setLength(0);
					j = 0;
				}
			} else {
				//重置，不然不连续的数字也会计算进去
				stringBuilder.setLength(0);
				j = 0;
			}
		}
		return resutl;
	}


	/**
	 * 判断字符串中是否存在，大于等于，指定长度的数字，找出并返回
	 *
	 * @param str  字符串
	 * @param size 数字的位数
	 * @return
	 * @author hzl 2021-10-25 11:37 AM
	 */
	public static List<String> hasLgEqFixNumStringReturn(String str, int size) {
		int j = 0;
		List<String> resutl=new ArrayList();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int chr = str.charAt(i);
			if (chr >= 48 && chr <= 57) {
				++j;
				System.out.println(str.charAt(i));
				stringBuilder.append(str.charAt(i));
				if((i==str.length()-1)&&j >= size){
					resutl.add(stringBuilder.toString());
				}
			} else {
				if (j >= size) {
					resutl.add(stringBuilder.toString());
				}
				//重置，不然不连续的数字也会计算进去
				stringBuilder.setLength(0);
				j = 0;
			}
		}
		return resutl;
	}


}
