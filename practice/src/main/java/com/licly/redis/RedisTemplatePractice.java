package com.licly.redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/21
 */
public class RedisTemplatePractice {

	@Resource
	private RedisTemplate redisTemplate;

	public void valuePractice() {

		String value = (String) redisTemplate.opsForValue().get("user");
		System.out.println(value);
	}

}
