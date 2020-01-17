package com.hzl.hadoop.util.email;

import lombok.*;

/**
 * description
 * 邮件类，
 *
 * @author hzl 2020/01/05 1:48 PM
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MailInfo {

	//发件人
	private String from;

	//收件人
	private String to;


}
