package com.hzl.hadoop.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * description
 * json处理工具类
 * @author hzl 2020/08/06 12:53 PM
 */
public class JsonUtils {

	/**
	 * <p>
	 * java对象转json字符串
	 * </p>
	 *
	 * @author hzl 2020/08/06 12:56 PM
	 */

	public static String objectToString(Object object){
		return JSON.toJSONString(object);
	}

	/**
	 * <p>
	 * json字符串转java对象
	 * </p>
	 *
	 * @author hzl 2020/08/06 12:58 PM
	 */

	public static Object jsonStringToObeject(String json){
		JSONObject jsonObejct = JSONObject.parseObject(json);
		return JSON.toJavaObject(jsonObejct, Object.class);
	}

	/**
	 *
	 *
	 * 实现对象克隆有两种方式：
	 *
	 * 1). 实现Cloneable接口并重写Object类中的clone()方法；（分为深拷贝和浅拷贝）
	 *
	 * 2). 实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆。
	 *
	 * 参考：https://www.cnblogs.com/Qian123/p/5710533.html
	 *
	 * json序列化方式克隆对象
	 * @param object 被克隆对象
	 * @author hzl 2020-08-19 2:20 PM
	 * @return
	 */
	public static Object cloneObject(Object object){
		String cloneObject=objectToString(object);
		return jsonStringToObeject(cloneObject);
	}

}
