package com.licly.kafka.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * kafka配置信息
 *
 * @author licly
 * @date 2020/10/8
 */

@Setter
@Getter
@ConfigurationProperties("mq.producer")
public class PropertyConfig {

	private String keySerializer;

	private String valueSerializer;

	private String ack;

	private String bootstrapServers;

}
