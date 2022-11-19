package com.roopy.delivery.producer;

import com.roopy.delivery.producer.config.KafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value={KafkaProperties.class})
public class KafkaDeliveryProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDeliveryProducerApplication.class, args);
	}

}
