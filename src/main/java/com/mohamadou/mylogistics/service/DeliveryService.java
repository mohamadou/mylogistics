package com.mohamadou.mylogistics.service;

import com.mohamadou.mylogistics.entity.*;
import com.mohamadou.mylogistics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {


    private DeliveryRepository deliveryRepository;
    private ParcelRepository parcelRepository;
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;
    private CarrierRepository carrierRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, ParcelRepository parcelRepository,
                           CustomerRepository customerRepository, AddressRepository addressRepository,
                           CarrierRepository carrierRepository) {
        this.deliveryRepository = deliveryRepository;
        this.parcelRepository = parcelRepository;
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.carrierRepository = carrierRepository;
    }

    public DeliveryService() {
    }

    public List<Delivery> getAllDelivery(){
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long deliveryId) {
         Optional<Delivery> deliveryOptional = deliveryRepository.findById(deliveryId);
         Delivery delivery = null;
         if (deliveryOptional.isPresent()) {
             delivery = deliveryOptional.get();
         }
         return delivery;
    }


    public void createDelivery(DeliveryRequest deliveryRequest) {

        deliveryRequest.setId(0L);
        Delivery delivery = new Delivery();
        Optional<Customer> optionalCustomer = customerRepository.findById(deliveryRequest.getCustomerId());
        if(optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            delivery.setCustomer(customer);
        }

        Optional<Parcel> parcelOptional = parcelRepository.findById(deliveryRequest.getParcelId());
        parcelOptional.ifPresent(delivery::setParcel);

        Optional<Address> deliveryAddressOptional = addressRepository.findById(deliveryRequest.getDeliveryAddressId());
        deliveryAddressOptional.ifPresent(delivery::setDeliveryAddress);

        Optional<Address> pickupAddressOptional = addressRepository.findById(deliveryRequest.getPickupAddressId());
        pickupAddressOptional.ifPresent(delivery::setPickupAddress);

        Optional<Carrier> carrierOptional = carrierRepository.findById(deliveryRequest.getCarrierId());
        carrierOptional.ifPresent(delivery::setCarrier);

        delivery.setDateCreated(LocalDate.now());
        deliveryRepository.save(delivery);
    }

    public void updateDelivery(DeliveryRequest deliveryRequestUpdate) {

        Delivery delivery = new Delivery();

        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryRequestUpdate.getId()) ;
        if (optionalDelivery.isPresent()) {
            delivery.setId(deliveryRequestUpdate.getId());

            Optional<Customer> optionalCustomer = customerRepository.findById(deliveryRequestUpdate.getCustomerId());
            if(optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                delivery.setCustomer(customer);
            }

            Optional<Parcel> parcelOptional = parcelRepository.findById(deliveryRequestUpdate.getParcelId());
            parcelOptional.ifPresent(delivery::setParcel);

            Optional<Address> deliveryAddressOptional = addressRepository.findById(deliveryRequestUpdate.getDeliveryAddressId());
            deliveryAddressOptional.ifPresent(delivery::setDeliveryAddress);

            Optional<Address> pickupAddressOptional = addressRepository.findById(deliveryRequestUpdate.getPickupAddressId());
            pickupAddressOptional.ifPresent(delivery::setPickupAddress);

            Optional<Carrier> carrierOptional = carrierRepository.findById(deliveryRequestUpdate.getCarrierId());
            carrierOptional.ifPresent(delivery::setCarrier);

            delivery.setDateCreated(LocalDate.now());
            deliveryRepository.save(delivery);
        } else {
            throw new IllegalStateException("Delivery with this id: "+ deliveryRequestUpdate.getId()+ " does not exist");
        }
    }

    public void deleteDelivery(Long deliveryId) {
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(deliveryId);

        if (deliveryOptional.isEmpty()) {
            throw new IllegalStateException("Delivery does not exist");
        }
        deliveryRepository.deleteById(deliveryId);
    }
}
