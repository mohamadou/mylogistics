package com.mohamadou.mylogistics.service;

import com.mohamadou.mylogistics.entity.Carrier;
import com.mohamadou.mylogistics.repository.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrierService {

    private CarrierRepository carrierRepository;

    public CarrierService() {

    }

    @Autowired
    public CarrierService(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
    }

    public List<Carrier> getAllCarriers() {
        return carrierRepository.findAll();
    }

    public Carrier getCarrierById(Long carrierId) {
        Optional<Carrier> optionalCarrier = carrierRepository.findById(carrierId);
        if (optionalCarrier.isEmpty()) {
           throw new IllegalStateException("Carrier with id: "+carrierId+" does not exist");
        }
        return optionalCarrier.get();
    }

    public Carrier createCarrier(Carrier carrier) {
        carrier.setId(0L);
        return carrierRepository.save(carrier);
    }

    public Carrier updateCarrier(Carrier carrier) {
        Optional<Carrier> carrierOptional = carrierRepository.findById(carrier.getId());
        if (carrierOptional.isEmpty()) {
            throw new IllegalStateException("Carrier with id: "+carrier.getId()+" does not exist");
        }
        return  carrierRepository.save(carrier);
    }

    public void deleteCarrier(Long carrierId) {
        Optional<Carrier> carrierOptional = carrierRepository.findById(carrierId);
        if (carrierOptional.isEmpty()) {
            throw new IllegalStateException("Carrier with id: "+carrierId+" does not exist");
        }
        carrierRepository.deleteById(carrierId);
    }
}
