package com.hzl.hadoop.app.service;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * description
 *
 * @author hzl 2020/01/07 12:57 PM
 */
public interface FreemarkerService {

	String getFreemarkerHtml(String path, Map<String, Object> value) throws IOException, TemplateException;

}
