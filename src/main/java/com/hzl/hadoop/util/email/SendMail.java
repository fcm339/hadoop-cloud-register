package com.hzl.hadoop.util.email;

import com.hzl.hadoop.util.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author hzl 2020/01/05 1:48 PM
 */
@Component
public class SendMail {

	@Autowired
	private MailService mailService;


	public void testMail() throws MessagingException {

		Map<String, String> attachmentMap = new HashMap<>();
		attachmentMap.put("附件", "file.txt的绝对路径");

		mailService.sendHtmlMail("测试Springboot发送带附件的邮件", "欢迎进入<a href=\"http://www.baidu.com\">百度首页</a>", attachmentMap);

	}

}
