package com.licly.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Kafka producer send方法回调
 *
 * @author licly
 * @date 2020/10/9
 */
@Slf4j
public class KafkaPushCallback implements Callback {

	@Override
	public void onCompletion(RecordMetadata recordMetadata, Exception e) {
		if (e != null) {
			log.error("kafka producer 发送消息失败");
		} else {
			log.debug("Producer message : partition [{}], offset [{}]", recordMetadata.partition(), recordMetadata.offset());
		}
	}
}

