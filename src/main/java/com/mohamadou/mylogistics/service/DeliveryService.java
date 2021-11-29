package com.mohamadou.mylogistics.service;

import com.mohamadou.mylogistics.entity.*;
import com.mohamadou.mylogistics.repository.AddressRepository;
import com.mohamadou.mylogistics.repository.CustomerRepository;
import com.mohamadou.mylogistics.repository.DeliveryRepository;
import com.mohamadou.mylogistics.repository.ParcelRepository;
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

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, ParcelRepository parcelRepository, CustomerRepository customerRepository, AddressRepository addressRepository) {
//    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
        this.parcelRepository = parcelRepository;
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
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

    public void createDelivery(DeliveryRequestCreate deliveryRequestCreate) {

        Delivery delivery = new Delivery();
        Optional<Customer> optionalCustomer = customerRepository.findById(deliveryRequestCreate.getCustomerId());
        if(optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            delivery.setCustomer(customer);
        }

        Optional<Parcel> parcelOptional = parcelRepository.findById(deliveryRequestCreate.getParcelId());
        parcelOptional.ifPresent(delivery::setParcel);

        Optional<Address> deliveryAddressOptional = addressRepository.findById(deliveryRequestCreate.getDeliveryAddressId());
        deliveryAddressOptional.ifPresent(delivery::setDeliveryAddress);

        Optional<Address> pickupAddressOptional = addressRepository.findById(deliveryRequestCreate.getPickupAddressId());
        pickupAddressOptional.ifPresent(delivery::setPickupAddress);

        delivery.setDateCreated(LocalDate.now());
        deliveryRepository.save(delivery);
    }

/*    public void createDelivery(Long customerId, Long parcelId, Long delivery_address_id,) {
        Delivery delivery = new Delivery();

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            delivery.setCustomer(customer);
        }

        delivery.setDateCreated(LocalDate.now());

        Optional<Parcel> parcelOptional = parcelRepository.findById(parcelId);
        parcelOptional.ifPresent(delivery::setParcel);


        deliveryRepository.save(delivery);
    }*/


   /* public Delivery createDelivery(Carrier carrier, Parcel parcel, Customer customer, Address addressPickup, Address addressDelivery){
        return null;
    }*/
}
