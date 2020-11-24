package com.hzl.hadoop.gp.job;

import com.hzl.hadoop.gp.constant.GpUrlConstant;
import com.hzl.hadoop.gp.service.GpNoticeService;
import com.hzl.hadoop.gp.service.GpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;


/**
 * description
 * 参考：https://blog.csdn.net/czx2018/article/details/83501945
 *
 * @author hzl 2020/11/03 2:14 PM
 */
@Slf4j
@Component
public class GpBasicInfoJob {
	@Autowired
	private GpService gpService;
	@Autowired
	private GpNoticeService gpNoticeService;

	/**
	 * 设置定时器的线程池
	 *
	 * @return
	 * @author hzl 2020-11-03 2:28 PM
	 */
	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(5);
		return taskScheduler;
	}


	/**
	 * fixedDelay 上传方法执行完成后开始计算
	 * 30秒执行一次
	 *
	 * @author hzl 2020-11-03 2:27 PM
	 * @}eturn
	 */
//	@Scheduled(fixedDelay = 30 * 1000)
//	public void getBasicInfoYl() {
//		log.info("定时器获取中兴时时基础数据d----------------------------------------------------" + Thread.currentThread());
//		gpService.insert(GpUrlConstant.GP_CODE_YL);
//
//		log.info("定时器获取伊利时时基础数据----------------------------------------------------" + Thread.currentThread());
//		gpService.insert(GpUrlConstant.GP_CODE_ZX);
//
//		log.info("定时器获取海尔时时基础数据----------------------------------------------------" + Thread.currentThread());
//		gpService.insert(GpUrlConstant.GP_CODE_HE);
//
//	}


	/**
	 * fixedDelay 上传方法执行完成后开始计算
	 * 30秒执行一次
	 * 竞价信息提醒
	 * 该功能不依赖数据库的
	 *
	 * @author hzl 2020-11-03 2:27 PM
	 * @}eturn
	 */
//	@Scheduled(cron = "0 15-25 9 * * ?")
//	public void getBaddingNoticeZX() {
//		log.info("中兴竞价提醒开始----------------------------------------------------" + Thread.currentThread());
//		gpNoticeService.bidding(GpUrlConstant.GP_CODE_ZX);
//		log.info("伊利竞价提醒开始----------------------------------------------------" + Thread.currentThread());
//		gpNoticeService.bidding(GpUrlConstant.GP_CODE_YL);
//		log.info("海尔竞价提醒开始----------------------------------------------------" + Thread.currentThread());
//		gpNoticeService.bidding(GpUrlConstant.GP_CODE_HE);
//	}


	/**
	 * 最高价，最低价波动情况,邮件提醒
	 * 5分钟执行一次
	 * 竞价信息提醒
	 *
	 * @author hzl 2020-11-03 2:27 PM
	 * @}eturn
	 */
//	@Scheduled(fixedDelay = 5 * 60 * 1000)
//	public void getvolatilityPricegNoticeZX() {
//		log.info("伊利高低价波动提醒----------------------------------------------------" + Thread.currentThread());
//		gpNoticeService.volatilityPriceSendMail(GpUrlConstant.GP_CODE_YL);
//
//		log.info("中兴高低价波动提醒----------------------------------------------------" + Thread.currentThread());
//		gpNoticeService.volatilityPriceSendMail(GpUrlConstant.GP_CODE_HE);
//	}
}
