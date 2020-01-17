package com.hzl.hadoop.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * description
 * 当缓存读写异常时,忽略异常
 *
 * @author hzl 2020/01/17 3:19 PM
 */
@Slf4j
public class IgnoreExceptionCacheErrorHandler implements CacheErrorHandler {

	@Override
	public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {
		log.error("redis读取异常", e);
	}

	@Override
	public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
		log.error("redis更新异常", e);
	}

	@Override
	public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
		log.error("redis失效缓存异常", e);

	}

	@Override
	public void handleCacheClearError(RuntimeException e, Cache cache) {
		log.error("redis清除缓存异常", e);
	}
}
