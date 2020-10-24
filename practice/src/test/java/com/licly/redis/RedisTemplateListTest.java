package com.licly.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/22
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTemplateListTest {

	@Resource
	private RedisTemplate<String, String> redis;

	@Before
	public void initValue() {
		redis.opsForList().rightPush("lang", "java");
		redis.opsForList().rightPush("lang", "c");
		redis.opsForList().rightPush("lang", "c++");
	}

	@Test
	public void testLeftPop() {
		String value = redis.opsForList().leftPop("lang");
		System.out.println(value);
	}

	@Test
	public void test() {
		List<String> lang = redis.opsForList().range("lang", 1, 3);
		System.out.println(lang);
	}

}
