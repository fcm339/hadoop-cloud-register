package com.hzl.hadoop.config.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * description
 * 1：springboot默认提供StringRedisTemplate和RedisTemplate,前者操作字符串的数据结构，后者你用JDK的序列化策略
 * 2：StringRedisTemplate继承了RedisTemplate
 * 3：配置redis的序列化策略，这里我们配置json的序列化，不然每个类都需要实现Serializable
 * @author hzl 2020/01/17 10:57 AM
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {



}
