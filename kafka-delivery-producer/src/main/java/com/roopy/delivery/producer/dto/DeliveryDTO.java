package com.roopy.delivery.producer.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO implements Serializable {
    private String carNo;
    private DeliveryStatus deliveryStatus;
}
