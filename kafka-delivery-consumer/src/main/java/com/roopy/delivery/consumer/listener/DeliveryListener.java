package com.roopy.delivery.consumer.listener;

import com.roopy.delivery.consumer.config.KafkaConstants;
import com.roopy.delivery.consumer.dto.DeliveryDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeliveryListener {

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.CONSUMER_GROUP_ID)
    public void listen(ConsumerRecord<String, DeliveryDTO> record) {
        log.info("Delivery info received : {}", record.value());

        // React SockJsClient 사용시 메세지 수신을 위해서는
        // 아래 template.convertAndSend 부분에서 선언된 topic 명을
        // 사용하면 된다.
        //
        // <SockJsClient
        //      ...
        //      topics={['/topic/delivery']}
        // />
        template.convertAndSend("/topic/delivery", record.value());
    }
}
