package com.hzl.hadoop.util.sensitiveword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @version 1.0
 * @Description: 初始化敏感词库，将敏感词加入到HashMap中，构建DFA算法模型
 * @Project：test
 * @Author : chenming
 * @Date ： 2014年4月20日 下午2:27:06
 */
public class SensitiveWordInit {
	private String ENCODING = "GBK";    //字符编码
	@SuppressWarnings("rawtypes")
	public HashMap sensitiveWordMap;

	public SensitiveWordInit() {
		super();
	}

	/**
	 * @author chenming
	 * @date 2014年4月20日 下午2:28:32
	 * @version 1.0
	 */
	@SuppressWarnings("rawtypes")
	public Map initKeyWord() {
		try {
			//读取敏感词库
			Set<String> keyWordSet = readSensitiveWordFile();
			//将敏感词库加入到HashMap中
			addSensitiveWordToHashMap(keyWordSet);
			//spring获取application，然后application.setAttribute("sensitiveWordMap",sensitiveWordMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sensitiveWordMap;
	}

	/**
	 * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br>
	 * 中 = {
	 * isEnd = 0
	 * 国 = {<br>
	 * isEnd = 1
	 * 人 = {isEnd = 0
	 * 民 = {isEnd = 1}
	 * }
	 * 男  = {
	 * isEnd = 0
	 * 人 = {
	 * isEnd = 1
	 * }
	 * }
	 * }
	 * }
	 * 五 = {
	 * isEnd = 0
	 * 星 = {
	 * isEnd = 0
	 * 红 = {
	 * isEnd = 0
	 * 旗 = {
	 * isEnd = 1
	 * }
	 * }
	 * }
	 * }
	 *
	 * @param keyWordSet 敏感词库
	 * @author chenming
	 * @date 2014年4月20日 下午3:04:20
	 * @version 1.0
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
		sensitiveWordMap = new HashMap(keyWordSet.size());     //初始化敏感词容器，减少扩容操作
		String key = null;
		Map nowMap = null;
		Map<String, String> newWorMap = null;
		//迭代keyWordSet
		Iterator<String> iterator = keyWordSet.iterator();
		while (iterator.hasNext()) {
			key = iterator.next();    //关键字
			nowMap = sensitiveWordMap;
			for (int i = 0; i < key.length(); i++) {
				char keyChar = key.charAt(i);       //转换成char型
				Object wordMap = nowMap.get(keyChar);       //获取

				if (wordMap != null) {        //如果存在该key，直接赋值
					nowMap = (Map) wordMap;
				} else {     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
					newWorMap = new HashMap<String, String>();
					newWorMap.put("isEnd", "0");     //不是最后一个
					nowMap.put(keyChar, newWorMap);
					nowMap = newWorMap;
				}

				if (i == key.length() - 1) {
					nowMap.put("isEnd", "1");    //最后一个
				}
			}
		}
	}

	/**
	 * 读取敏感词库中的内容，将内容添加到set集合中
	 *
	 * @return
	 * @throws Exception
	 * @author chenming
	 * @date 2014年4月20日 下午2:31:18
	 * @version 1.0
	 */
	@SuppressWarnings("resource")
	private Set<String> readSensitiveWordFile() throws Exception {

		Set<String> set=new HashSet<>();
		set.add("地铁");
		set.add("5分");
		set.add("湖版块");
		return set;
	}
}
