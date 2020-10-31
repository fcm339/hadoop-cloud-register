package com.hzl.hadoop.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description
 * 集合工具类
 *
 * @author hzl 2020/10/31 1:08 PM
 */
public class ListUtils {

	/**
	 * 将俩集合合并成一个map
	 *
	 * @param keys   键集合
	 * @param values 值集合
	 * @return
	 * @author hzl 2020-10-31 1:08 PM
	 */

	public static <k, v> Map<k, v> listToMap(List<k> keys, List<v> values) {
		return keys.stream().collect(Collectors.toMap(key -> key, key -> values.get(keys.indexOf(key))));
	}
}
