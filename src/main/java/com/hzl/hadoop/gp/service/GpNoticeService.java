package com.hzl.hadoop.gp.service;

import com.hzl.hadoop.gp.vo.MaxMinHtmlVO;

/**
 * description
 *
 * @author hzl 2020/11/03 6:29 PM
 */
public interface GpNoticeService {
	/**
	 * <p>
	 * 竞价提醒
	 * </p>
	 * 
	 * @author hzl 2020/11/03 6:49 PM
	 */
	void bidding(String gpCode);

	/**
	 * <p>
	 * 价格波动提醒，时时查询
	 * </p>
	 *
	 * @author hzl 2020/11/03 6:49 PM
	 */
	MaxMinHtmlVO volatilityPrice(String gpCode);



	/**
	 * <p>
	 * 价格波动提醒，定时器发送邮件
	 * </p>
	 *
	 * @author hzl 2020/11/03 6:49 PM
	 */
	void volatilityPriceSendMail(String gpCode);
}
