package com.hzl.hadoop.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;


/**
 * description
 * 1：springboot默认提供StringRedisTemplate和RedisTemplate,前者操作字符串的数据结构，后者你用JDK的序列化策略
 * 2：StringRedisTemplate继承了RedisTemplate
 * 3：配置redis的序列化策略，这里我们配置json的序列化，不然每个类都需要实现Serializable
 * 参考：https://blog.csdn.net/sz85850597/article/details/89301331
 *
 * @author hzl 2020/01/17 10:57 AM
 * @EnableCaching开启springboot的@cache注解
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	/**
	 * <p>
	 * 当redis服务器发生异常时，忽略异常，然后返回空值，从而读取数据库
	 * 这样就不会因为redis异常导致服务无法正常使用
	 * ，虽然业务功能可以正常使用，但是mysql的压力会增加导致缓存雪崩（通过多层缓存方式，直接缓存到应用不合适，增加
	 * 其他缓存服务器成本较高，推荐方案redis集群，主从),小型erp系统基本不需要考虑
	 * </p>
	 *
	 * @author hzl 2020/01/17 3:18 PM
	 */
	@Override
	@Nullable
	public CacheErrorHandler errorHandler() {
		return new IgnoreExceptionCacheErrorHandler();
	}

	/**
	 * <p>
	 * 没有必要，完全可以在调用RedisTemplate的时候指定
	 * 生成key的策略 根据类名+方法名+所有参数的值生成唯一的一个key
	 *
	 * @Cacheable等注解可以手动指定该键生成规则 </p>
	 * @author hzl 2020/01/17 3:10 PM
	 */
	@Override
	public KeyGenerator keyGenerator() {
		//StringBuilder线程不安全，StringBuffer线程安全
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

	/**
	 * <p>
	 * 定义RedisTemplate存入redis时的key,value的序列化策略
	 * 覆盖RedisAutoConfiguration
	 * </p>
	 *
	 * @author hzl 2020/01/17 3:10 PM
	 */
	@Bean
	@ConditionalOnMissingBean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		//设置键的序列号为string
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//设置值的序列化为json
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

		return redisTemplate;
	}
}
