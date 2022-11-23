package com.roopy.delivery.producer.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO implements Serializable {
    private String id;
    private DeliveryStatus status;
    @ApiModelProperty(value = "statusColor", hidden = true)
    private DeliveryStatusColor statusColor;
}
