package com.licly.kafka;

import com.licly.kafka.config.PropertyConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Properties;

/**
 * Kafka生产者
 *
 * @author licly
 * @date 2020/10/8
 */

@Component
public class KafkaProducerClient {

	@Resource
	private PropertyConfig config;

	@PostConstruct
	public void init() {
		Properties props = new Properties();
		props.put("bootstrap.servers", config.getBootstrapServers());
		props.put("acks", config.getAck());
		props.put("key.serializer", config.getKeySerializer());
		props.put("value.serializer", config.getValueSerializer());

		Producer<String, String> producer = new KafkaProducer<>(props);
		producer.send(new ProducerRecord<>("micro_service-test", "test-message"), new KafkaPushCallback());


	}
}
