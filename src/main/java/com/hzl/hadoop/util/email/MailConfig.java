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
public class MailConfig {

	private String from;

	private String to;


}
