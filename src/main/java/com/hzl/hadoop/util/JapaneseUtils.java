package com.hzl.hadoop.util;

import java.util.HashMap;
import java.util.Random;

/**
 * description
 * 日语五十音
 *
 * @author hzl 2020/04/07 2:15 PM
 */
public class JapaneseUtils {

	//hashmap无序的非线程安全
	private static HashMap<String, String> hashMap = new HashMap<>();


	/**
	 * 日语50音输入读音，输出日文
	 *
	 * @return
	 * @author hzl 2020-04-07 4:10 PM
	 */
	public static void englishToJapanese() {

		hashMap.put("a", "あ、ア");
		hashMap.put("i", "");
	}


	/**
	 * 日语50音随机排序输出
	 *
	 * @return
	 * @author hzl 2020-04-07 4:09 PM
	 */
	public static void random() {
		int a;
		int b;
		String tem;
		Random rand = new Random();

		String arr[] = {"あ", "い", "う", "え", "お",
				"か", "き", "く", "け", "こ",
				"さ", "し", "す", "せ", "そ",
				"た", "ち", "つ", "て", "と",
				"な", "に", "ぬ", "ね", "の",
				"は", "ひ", "ふ", "へ", "ほ",
				"ま", "み", "む", "め", "も",
				"や", "ゆ", "よ", "わ", "を",
				"ら", "り", "る", "れ", "ろ",
				"ん",};
		for (int i = 0; i < 300; i++) {
			a = rand.nextInt(46);
			b = rand.nextInt(46);
			tem = arr[a];
			arr[a] = arr[b];
			arr[b] = tem;
		}

		for (int i = 0; i < 46; i++) {
			if (i > 0 & (i + 1) % 5 == 0) {
				System.out.println(arr[i] + " ");
			} else {
				System.out.print(arr[i] + " ");
			}

		}
	}


	public static void main(String args[]){
		random();
	}

}
