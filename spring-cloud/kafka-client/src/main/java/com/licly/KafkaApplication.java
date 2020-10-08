package com.licly;

import com.google.inject.internal.cglib.core.$Constants;
import com.licly.kafka.config.PropertyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.Resource;

/**
 * Kafka启动类
 *
 * @author licly
 * @date 2020/10/8
 */

@SpringBootApplication
@ConfigurationPropertiesScan
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
