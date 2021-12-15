package com.hzl.hadoop.gp.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

/**
 * description
 * https://vip.stock.finance.sina.com.cn/corp/go.php/vCB_AllNewsStock/symbol/sz000651.phtml
 * 爬取新浪个股资讯
 * @author hzl 2021/12/14 2:27 PM
 */
public interface XinLangNews {

	boolean getTodayNews(String gpCode) throws IOException;


}
