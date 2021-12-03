package com.mohamadou.mylogistics.config;

import com.mohamadou.mylogistics.entity.*;
import com.mohamadou.mylogistics.repository.*;
import com.mohamadou.mylogistics.service.AddressService;
import com.mohamadou.mylogistics.service.DeliveryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunnerCustomer  (
            CustomerRepository customerRepository,
            AddressRepository addressRepository,
            AddressService addressService,
            CarrierRepository carrierRepository,
            DeliveryRepository deliveryRepository,
            DeliveryService deliveryService,
            ParcelRepository parcelRepository
    ) {
        return args -> {
           Customer mohamadou = new Customer(
                    "Mohamadou",
                    "Ndiaye",
                    "99000000",
                    "mohamadou@gmail.com"
            );
            Customer aissatou = new Customer(
                    "Aissatou",
                    "Diop",
                    "77777777",
                    "aissatou@gmail.com"
            );
            Customer john = new Customer(
                    "John",
                    "Doe",
                    "88898282",
                    "john@gmail.com"
            );

            customerRepository.saveAll(
                    List.of(mohamadou,aissatou,john)
            );

            // Create and save Address
//            addressService.createAddress(1L, new Address("Sénégal", "Dakar","1234", "Mermoz"));
//            addressService.createAddress(1L, new Address("Sénégal", "Ourossogui","4543", "Moderne"));
//            addressService.createAddress(2L, new Address("France", "Paris","7904", "Rue des "));

            // Create and save Carrier
            carrierRepository.saveAll(
                    List.of(
                            new Carrier("Express 12h"),
                            new Carrier("Express 24h"),
                            new Carrier("Delivery 48")
                    )
            );

            // Create and save parcel
            parcelRepository.saveAll(
                    List.of(
                            new Parcel("Book for children", 10.0),
                            new Parcel("Basket Nike", 2.0),
                            new Parcel("Computer Macbook", 3.0),
                            new Parcel("Macbook Pro M1", 1.0)
                    )
            );

            // Create and save Delivery by using the DeliveryService
           /* deliveryService.createDelivery(new DeliveryRequest(1L, 1L, 1L, 2L, 1L));
            deliveryService.createDelivery(new DeliveryRequest(1L, 2L, 2L, 2L, 1L));
            deliveryService.createDelivery(new DeliveryRequest(1L, 3L, 3L, 3L, 2L));
            deliveryService.createDelivery(new DeliveryRequest(1L, 1L, 4L, 3L, 2L));*/

        };
    }
}
