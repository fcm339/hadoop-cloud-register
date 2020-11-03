package com.hzl.hadoop.gp.job;

import com.hzl.hadoop.gp.service.GpService;
import com.hzl.hadoop.gp.vo.GpVO;
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
 * @author hzl 2020/11/03 2:14 PM
 */
@Slf4j
@Component
public class GpBasicInfoJob {
	@Autowired
	private GpService gpService;

	/**
	 *
	 * 设置定时器的线程池
	 * @author hzl 2020-11-03 2:28 PM
	 * @return
	 */
	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(5);
		return taskScheduler;
	}
	/**
	 *fixedDelay 上传方法执行完成后开始计算
	 *30秒执行一次
	 * @author hzl 2020-11-03 2:27 PM
	 * @return
	 */
	@Scheduled(fixedDelay = 30*1000)
	public void getBasicInfo() {
		log.info("current thread----------------------------------------------------"+Thread.currentThread());
		GpVO gpVO = gpService.insert("sz000063");
		log.info("定时器获取中兴数据：" + gpVO.toString());
	}

}
