package com.mohamadou.mylogistics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeliveryRequestCreate {

    private Long customerId;

    private Long carrierId;

    private Long parcelId;

    private Long pickupAddressId;

    private Long deliveryAddressId;
}
