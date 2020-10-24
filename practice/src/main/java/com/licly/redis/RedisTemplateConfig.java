package com.licly.redis;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/22
 */

@Configurable
public class RedisTemplateConfig {

	@Bean
	public RedisTemplate redisTemplate() {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
		return redisTemplate;
	}
}
