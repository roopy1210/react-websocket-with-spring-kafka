package com.roopy.delivery.consumer;

import com.roopy.delivery.consumer.config.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {KafkaProperties.class})
public class KafkaDeliveryConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDeliveryConsumerApplication.class, args);
	}

}
