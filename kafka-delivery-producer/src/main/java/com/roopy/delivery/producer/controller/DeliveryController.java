package com.roopy.delivery.producer.controller;

import com.roopy.delivery.producer.dto.DeliveryDTO;
import com.roopy.delivery.producer.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/status")
    public String sendDeliveryStatus (@RequestBody DeliveryDTO deliveryDTO) {
        deliveryService.sendDeliveryStatus(deliveryDTO);

        return "Success";
    }
}
