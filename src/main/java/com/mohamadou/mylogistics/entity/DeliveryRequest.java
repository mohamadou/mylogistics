package com.mohamadou.mylogistics.entity;

import lombok.Data;


@Data
public class DeliveryRequest {

    private Long id;

    private Long customerId;

    private Long carrierId;

    private Long parcelId;

    private Long pickupAddressId;

    private Long deliveryAddressId;

    public DeliveryRequest(Long id, Long customerId, Long carrierId, Long parcelId, Long pickupAddressId, Long deliveryAddressId) {
        this.id = id;
        this.customerId = customerId;
        this.carrierId = carrierId;
        this.parcelId = parcelId;
        this.pickupAddressId = pickupAddressId;
        this.deliveryAddressId = deliveryAddressId;
    }

    public DeliveryRequest(Long customerId, Long carrierId, Long parcelId, Long pickupAddressId, Long deliveryAddressId) {
        this.customerId = customerId;
        this.carrierId = carrierId;
        this.parcelId = parcelId;
        this.pickupAddressId = pickupAddressId;
        this.deliveryAddressId = deliveryAddressId;
    }

    public DeliveryRequest() {
    }
}

