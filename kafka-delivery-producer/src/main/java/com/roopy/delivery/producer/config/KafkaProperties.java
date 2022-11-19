package com.roopy.delivery.producer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka")
@Data
public class KafkaProperties {
    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootStrapServers;
}
