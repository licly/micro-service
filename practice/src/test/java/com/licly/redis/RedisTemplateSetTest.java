package com.licly.redis;

import com.licly.PracticeApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/22
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = PracticeApplication.class)
@RunWith(SpringRunner.class)
public class RedisTemplateSetTest {

	@Resource
	private RedisTemplate<String, String> redis;

	@Before
	public void initValue() {
		redis.opsForSet().add("num", "1", "2", "3", "4");
	}

	@Test
	public void testMembers() {
		Set<String> num = redis.opsForSet().members("num");
		System.out.println(num);
	}

	@Test
	public void testIsMember() {
		Boolean num = redis.opsForSet().isMember("num", "1");
		System.out.println(num);
	}

	@Test
	public void testDifference() {
		// Set<String> num = redis.opsForSet().difference("num", List.of("4"));
		// System.out.println(num);
	}
}
