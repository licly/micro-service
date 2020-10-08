package com.licly.kafka;

import com.licly.kafka.config.PropertyConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Kafka消费者
 *
 * @author licly
 * @date 2020/10/8
 */

@Component
public class KafkaConsumerClient {

	@Resource
	private PropertyConfig config;

	@PostConstruct
	public void init() {

	}
}
