package com.roopy.delivery.consumer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka")
@Data
public class KafkaProperties {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootStrapServers;

}
