package com.hzl.hadoop.userlog;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * IP工具类
 *
 * @author pangu
 */
@Slf4j
public class IPUtil {

	private final static boolean ipLocal = false;

	/**
	 * 根据ip获取详细地址
	 */
	public static String getCityInfo(String ip) {
		if (ipLocal) {
			//待开发
			return null;
		} else {
			return getHttpCityInfo(ip);
		}
	}

	/**
	 * 根据ip获取详细地址
	 * 临时使用，待调整
	 */
	public static String getHttpCityInfo(String ip) {
		String api = String.format("http://whois.pconline.com.cn/ipJson.jsp?ip=%s&json=true", ip);
		JSONObject object = JSON.parseObject((String) HttpUtil.get(api,10000));
		log.info(object.toJSONString());
		return object.getString("addr");
	}




	public static void main(String[] args) {
		System.err.println(getCityInfo("117.61.241.206"));
	}
}
