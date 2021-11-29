package com.mohamadou.mylogistics.config;

import com.mohamadou.mylogistics.entity.Customer;
import com.mohamadou.mylogistics.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunnerCustomer  (CustomerRepository customerRepository) {
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


        };
    }
}
