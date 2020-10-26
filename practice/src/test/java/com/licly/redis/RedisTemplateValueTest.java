package com.licly.redis;

import ch.qos.logback.core.util.TimeUtil;
import com.licly.PracticeApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/22
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = PracticeApplication.class)
@RunWith(SpringRunner.class)
public class RedisTemplateValueTest {

	@Resource
	private RedisTemplate<String, String> redis;

	@Before
	public void initValue() {
		redis.opsForValue().set("count", "1");
		redis.opsForValue().set("user", "licly");
	}

	@Test
	public void testSet() {
	}

	@Test
	public void testGet() {
		Object user = redis.opsForValue().get("user");
		System.out.println(user);
	}

	@Test
	public void testIncr() {
		Long count = redis.opsForValue().increment("count", 1);
		System.out.println(count);
	}

	@Test
	public void testDecr() {
		Long count = redis.opsForValue().decrement("count");
		System.out.println(count);
	}

	@Test
	public void testIncrBy() {
		redis.opsForValue().increment("count", 2);
	}

	@Test
	public void testGetSet() {
		// 返回旧元素，设置新元素
		String count = redis.opsForValue().getAndSet("count", "4");
		System.out.println(count);
	}

	@Test
	public void testMultiSet() {
		// List<String> list = redis.opsForValue().multiGet(List.of("count", "user"));
		// System.out.println(list);
	}

	@Test
	public void testExpire() throws InterruptedException {
		redis.opsForValue().set("score", "10", Duration.ofMillis(5000));
		String score = redis.opsForValue().get("score");
		Long size = redis.opsForValue().size("score");
		System.out.println(score);
		System.out.println(size);

		TimeUnit.SECONDS.sleep(5);
		score = redis.opsForValue().get("score");
		System.out.println(score);
	}



}
