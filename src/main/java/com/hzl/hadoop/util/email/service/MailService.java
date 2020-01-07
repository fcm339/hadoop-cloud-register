package com.hzl.hadoop.util.email.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * description
 * 邮件发送接口
 *
 * @author hzl 2020/01/05 2:06 PM
 */
public interface MailService {

	Boolean sendSimpleMail(String subject, String text);

	Boolean sendHtmlMail(String subject, String text, Map<String, String> attachmentMap) throws MessagingException;

	Boolean sendTemplateMail(String subject, Map<String, String> params);
}
