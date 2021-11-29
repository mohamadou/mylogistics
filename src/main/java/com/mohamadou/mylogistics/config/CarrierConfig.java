package com.mohamadou.mylogistics.config;

import com.mohamadou.mylogistics.entity.Carrier;
import com.mohamadou.mylogistics.repository.CarrierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarrierConfig {

    @Bean
    CommandLineRunner commandLineRunnerCarrier (CarrierRepository customerRepository) {
        return args -> {
           Carrier express12 = new Carrier(
                    "Express 12h"
            );
            Carrier express24 = new Carrier(
                    "Express 24h"
            );

            Carrier delivery58 = new Carrier(
                    "Delivery 48"
            );


            customerRepository.saveAll(
                    List.of(express12,express24, delivery58)
            );

        };
    }
}
