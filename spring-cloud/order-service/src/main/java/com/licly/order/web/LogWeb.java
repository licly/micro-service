package com.licly.order.web;

import com.licly.utils.SleepUtils;
import com.mysql.cj.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @author licly
 * @date 2020/10/25
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogWeb implements HealthIndicator {

	private AtomicInteger counter = new AtomicInteger();

    @RequestMapping("/print")
    public void log() {
	    counter.incrementAndGet();
        // SleepUtils.sleep(1);
        log.info("info");
        log.debug("debug|");
        log.warn("warn");
        // throw new RuntimeException();
    }

	@Override
	public Health health() {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("count", counter.get());
		return new Health.Builder().up().withDetails(properties).build();
	}
}
