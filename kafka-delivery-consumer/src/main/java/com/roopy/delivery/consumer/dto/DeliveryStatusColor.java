package com.roopy.delivery.consumer.dto;

import lombok.Getter;

public enum DeliveryStatusColor {
    INDIGO("indigo"),
    ROSE("rose"),
    GREEN("green");

    @Getter
    private final String value;

    DeliveryStatusColor(String value) {
        this.value = value;
    }
}
