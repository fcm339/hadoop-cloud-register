package com.hzl.hadoop.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * description
 * CommandLineRunner和ApplicationRunner在SpringApplication.run()之前，在所有的beans加载完成之后执行，
 * 用于执行一些初始化操作(如加载缓存、读取配置文件、创建线程池等)
 * <p>
 * CommandLineRunner和ApplicationRunner的功能差不多，不同的是run接口的参数，CommandLineRunner#run(String… args)、
 * ApplicationRunner#run(ApplicationArguments args) ApplicationArguments包含更多的信息，其它功能都一样。
 * <p>
 * 当执行多个初始化操作时可以通过@Order(value)来配置执行顺序，value是一个int的值，value的值越小越先执行
 *
 * @author hzl 2020/01/14 10:21 AM
 */
@Order(1)
@Component
@Slf4j
public class CommandLineRunnerUtil implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("CommandLineRunner所有bean加载完成后执行" + Arrays.asList(args));

	}

}
