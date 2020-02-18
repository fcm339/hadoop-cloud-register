package com.hzl.hadoop.redis.common;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * description
 * redis锁操作
 * @author hzl 2020/02/03 3:00 PM
 */
public class RedisLock {

	/**
	 *
	 * redis加锁
	 * @param redisTemplate springredis模版
	 * @author hzl 2020-02-03 3:02 PM
	 * @return
	 */

	public void addLock(RedisTemplate redisTemplate){

	}


	/**
	 *
	 * redis解锁
	 * @param redisTemplate springredis模版
	 * @author hzl 2020-02-03 3:02 PM
	 * @return
	 */

	public void removeLock(RedisTemplate redisTemplate){

	}

	/**
	 *
	 * 获取锁
	 * @param redisTemplate
	 * @author hzl 2020-02-03 3:08 PM
	 * @return
	 */
	public void getLock(RedisTemplate redisTemplate){

	}
}
