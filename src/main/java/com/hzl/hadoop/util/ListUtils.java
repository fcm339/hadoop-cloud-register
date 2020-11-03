package com.hzl.hadoop.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
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

	/**
	 * 求并集
	 *
	 * @param source1 集合1
	 * @param source2 集合2
	 * @return
	 * @author hzl 2020-11-03 1:41 PM
	 */

	public static Collection<String> union(List<String> source1, List<String> source2) {
		return CollectionUtils.union(source1, source2);
	}


	/**
	 * 求交集
	 *
	 * @param source1 集合1
	 * @param source2 集合2
	 * @return
	 * @author hzl 2020-11-03 1:41 PM
	 */

	public static Collection<String> intersection(List<String> source1, List<String> source2) {
		return CollectionUtils.intersection(source1, source2);
	}


	/**
	 * 求交集的补集
	 *
	 * @param source1 集合1
	 * @param source2 集合2
	 * @return
	 * @author hzl 2020-11-03 1:41 PM
	 */

	public static Collection<String> disjunction(List<String> source1, List<String> source2) {
		return CollectionUtils.disjunction(source1, source2);
	}

	/**
	 * 求差集
	 *
	 * @param source1 集合1
	 * @param source2 集合2
	 * @return
	 * @author hzl 2020-11-03 1:41 PM
	 */

	public static Collection<String> subtract(List<String> source1, List<String> source2) {
		return CollectionUtils.subtract(source1, source2);
	}

	/**
	 * 集合是否相等
	 *
	 * @param source1 集合1
	 * @param source2 集合2
	 * @return
	 * @author hzl 2020-11-03 1:41 PM
	 */

	public static boolean isEqualCollection(List<String> source1, List<String> source2) {
		return CollectionUtils.isEqualCollection(source1, source2);
	}

}
