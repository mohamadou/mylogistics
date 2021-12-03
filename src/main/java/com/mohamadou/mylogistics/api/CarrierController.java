package com.mohamadou.mylogistics.api;

import com.mohamadou.mylogistics.entity.Carrier;
import com.mohamadou.mylogistics.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/carrier")
public class CarrierController {

    @Autowired
    CarrierService carrierService;

    @GetMapping
    public List<Carrier> getAllCarriers(){
        return carrierService.getAllCarriers();
    }

    @GetMapping(path = "/{carrierId}")
    public Carrier getCarrierById(@PathVariable Long carrierId) {
        return carrierService.getCarrierById(carrierId);
    }

    @PostMapping
    public Carrier createCarrier(@RequestBody Carrier carrier) {
        return carrierService.createCarrier(carrier);
    }

    @PutMapping
    public Carrier updateCarrier(@RequestBody Carrier carrier) {
        return carrierService.updateCarrier(carrier);
    }

    @DeleteMapping(path = "/{carrierId}")
    public void deleteCarrier(@PathVariable Long carrierId) {
        carrierService.deleteCarrier(carrierId);
    }






}
