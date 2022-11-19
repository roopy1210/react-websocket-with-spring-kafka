package com.roopy.delivery.consumer.dto;

import lombok.Getter;

public enum DeliveryStatus {
    PENDING("pending"),
    DELIVERING("delivering"),
    COMPLETE("complete");

    @Getter
    private final String value;

    DeliveryStatus(String value) {
        this.value = value;
    }
}
