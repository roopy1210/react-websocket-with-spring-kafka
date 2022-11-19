package com.roopy.delivery.producer.service;

import com.roopy.delivery.producer.dto.DeliveryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeliveryServiceImpl implements DeliveryService {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    @Override
    public void sendDeliveryStatus(DeliveryDTO deliveryDTO) {
        ListenableFuture<SendResult<String,Object>> listenableFuture = kafkaTemplate.send("deliveryTopic", deliveryDTO);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable e) {
                log.error("Send delivery status error occured...");
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("[{}] Delivery status changed to {}", deliveryDTO.getCarNo(), deliveryDTO.getDeliveryStatus());
            }
        });
    }
}
