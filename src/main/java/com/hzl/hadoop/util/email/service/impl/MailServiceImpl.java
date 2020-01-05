package com.hzl.hadoop.util.email.service.impl;

import com.hzl.hadoop.util.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * description
 *
 * @author hzl 2020/01/05 2:09 PM
 */
@Component
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * <p>
	 * 发送简单邮件
	 * </p>
	 *
	 * @author hzl 2020/01/05 2:34 PM
	 */
	@Override
	public void sendSimpleMail(String subject, String text) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("1620516418@qq.com");
		mailMessage.setTo("zhongliang.huang@hand-china.com");

		mailMessage.setSubject(subject);
		mailMessage.setText(text);

	}

	/**
	 * <p>
	 * 发送html邮件
	 * </p>
	 *
	 * @author hzl 2020/01/05 2:34 PM
	 */
	@Override
	public void sendHtmlMail(String subject, String text, Map<String, String> attachmentMap) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		//是否发送的邮件是富文本（附件，图片，html等）
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

		messageHelper.setFrom("");
		messageHelper.setTo("");

		messageHelper.setSubject(subject);
		messageHelper.setText(text, true);//重点，默认为false，显示原始html代码，无效果

		if (attachmentMap != null) {
			attachmentMap.entrySet().stream().forEach(entrySet -> {
				try {
					File file = new File(entrySet.getValue());
					if (file.exists()) {
						messageHelper.addAttachment(entrySet.getKey(), new FileSystemResource(file));
					}
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			});
		}

		javaMailSender.send(mimeMessage);

	}

	/**
	 * <p>
	 * 读取freemarker模版后发送邮件
	 * </p>
	 *
	 * @author hzl 2020/01/05 2:34 PM
	 */
	@Override
	public void sendTemplateMail(String subject, Map<String, Object> params) {


		//javaMailSender.send(mimeMessage);


	}
}
