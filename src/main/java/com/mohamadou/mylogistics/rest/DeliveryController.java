package com.mohamadou.mylogistics.rest;

import com.mohamadou.mylogistics.entity.Delivery;
import com.mohamadou.mylogistics.entity.DeliveryRequest;
import com.mohamadou.mylogistics.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/delivery")
public class DeliveryController {

    private DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public DeliveryController(){}

    @GetMapping
    public List<Delivery> getAllDelivery() {
        return deliveryService.getAllDelivery();
    }

    @GetMapping(path = "{deliveryId}")
    public Delivery getDeliveryById(@PathVariable Long deliveryId) {
        return deliveryService.getDeliveryById(deliveryId);
    }

    @PostMapping
    public void createDelivery(@RequestBody DeliveryRequest deliveryRequest) {
        deliveryService.createDelivery(deliveryRequest);
    }

    @PutMapping
    public void updateDelivery(@RequestBody DeliveryRequest deliveryRequest) {
        deliveryService.updateDelivery(deliveryRequest);
    }

}
