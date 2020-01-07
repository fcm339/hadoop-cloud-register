package com.hzl.hadoop.app.service.impl;

import com.hzl.hadoop.app.service.FreemarkerService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * description
 *
 * @author hzl 2020/01/07 12:57 PM
 */
@Component
@Slf4j
public class FreemarkerServiceImpl implements FreemarkerService {
	@Resource
	private Configuration freemarkerConfig;

	/**
	 * <p>
	 * 获取freemarker的html内容
	 * path：模版路径
	 * value：模版中需要替换的内容对象
	 * </p>
	 *
	 * @author hzl 2020/01/07 1:00 PM
	 */
	@Override
	public String getFreemarkerHtml(String path, Map<String,Object> value) throws IOException, TemplateException {
		log.info("参数对象" + value.toString());
		//通过指定模板名获取FreeMarker模板实例
		Template tpl = freemarkerConfig.getTemplate(path);
		return FreeMarkerTemplateUtils.processTemplateIntoString(tpl, value);
	}
}
