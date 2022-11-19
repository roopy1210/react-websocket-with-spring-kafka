package com.roopy.delivery.producer.service;

import com.roopy.delivery.producer.dto.DeliveryDTO;

public interface DeliveryService {
    public void sendDeliveryStatus(DeliveryDTO deliveryDTO);
}
